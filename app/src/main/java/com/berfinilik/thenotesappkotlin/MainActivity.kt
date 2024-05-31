package com.berfinilik.thenotesappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.berfinilik.thenotesappkotlin.database.NoteDatabase
import com.berfinilik.thenotesappkotlin.repository.NoteRepository
import com.berfinilik.thenotesappkotlin.viewmodel.NoteViewModel
import com.berfinilik.thenotesappkotlin.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var notesViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        setupViewModel()
    }

    private fun setupViewModel(){
        val noteRepository=NoteRepository(NoteDatabase(this))
        val viewModelProviderFactory=NoteViewModelFactory(application,noteRepository)
        notesViewModel=ViewModelProvider(this,viewModelProviderFactory)[NoteViewModel::class.java]
    }
}