package com.berfinilik.thenotesappkotlin.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.berfinilik.thenotesappkotlin.MainActivity
import com.berfinilik.thenotesappkotlin.R
import com.berfinilik.thenotesappkotlin.databinding.FragmentEditNoteBinding
import com.berfinilik.thenotesappkotlin.model.Note
import com.berfinilik.thenotesappkotlin.viewmodel.NoteViewModel

class EditNoteFragment : Fragment(R.layout.fragment_edit_note),MenuProvider {

    private var _binding: FragmentEditNoteBinding? = null

    private val binding get() = _binding!!

    private lateinit var noteViewModel: NoteViewModel
    private lateinit var currentNote: Note

    private val args:EditNoteFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEditNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        noteViewModel = (activity as MainActivity).notesViewModel
        currentNote= args.note!!

       binding.editNoteTitle.setText(currentNote.noteTitle)
       binding.editNoteDesc.setText(currentNote.noteDesc)

        binding.editNoteFab.setOnClickListener {
            val noteTitle=binding.editNoteTitle.text.toString().trim()
            val noteDesc=binding.editNoteDesc.text.toString().trim()

            if (noteTitle.isNotEmpty()) {
                val note = Note(currentNote.id, noteTitle, noteDesc)
                noteViewModel.updateNote(note)

                view.findNavController().popBackStack(R.id.homeFragment, false)
            } else {
                Toast.makeText(context, "Lütfen not başlığını giriniz.", Toast.LENGTH_LONG)
                    .show()
            }
            Toast.makeText(context,"Not Güncellendi.",Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteNote(){
        AlertDialog.Builder(activity).apply {
            setTitle("Notu Sil")
            setMessage("Notu silmek istediğinizden emin misiniz?")
            setPositiveButton("Sil"){_,_->
                noteViewModel.deleteNote(currentNote)
                Toast.makeText(context,"Not Silindi",Toast.LENGTH_SHORT).show()
                view?.findNavController()?.popBackStack(R.id.homeFragment,false)
            }
            setNegativeButton("İptal",null)
        }.create().show()
    }


    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menu.clear()
        menuInflater.inflate(R.menu.edit_note_menu,menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId){
            R.id.deleteMenu ->{
                deleteNote()
                true
            }else->false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}