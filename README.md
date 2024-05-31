KULLANILAN TEKNOLOJİLER

View Binding
Navigation Component
Room
MVVM
Coroutines
LiveData


EKRAN GÖRÜNTÜLERİ ->

Bu, boş bir notlar uygulamasında temel olarak hiçbir not bulunmadığında görüntülenecek ilk ekran olacaktır.

![58445411-c01d-4484-bc99-e0651c0e019e](https://github.com/berfinilik/TheNotesApp/assets/140311905/8b743adc-3517-4135-8141-e4161fc2e49d)


Bu, bir not başlığı ve not açıklaması ekleyebileceğiniz AddNoteFragment'tir.
AddNoteFragment

![2f0e9613-653b-4505-ae9e-aa2824a97ac1](https://github.com/berfinilik/TheNotesApp/assets/140311905/e0601f62-93ff-4b29-bba8-a70067607d1d)


Burası HomeFragment, burada tüm notlar recyclerviewda görüntülenecek.
Ayrıca eylem çubuğunda bir kaydetme düğmesi bulunur.

![64aead7e-3330-4a70-a40b-6de1a8725c21](https://github.com/berfinilik/TheNotesApp/assets/140311905/dfb4d063-95d0-474b-8c07-4c96c64ae2ea)

Burası HomeFragment, burada tüm notlar kademeli düzen kullanılarak geri dönüşüm görünümünde görüntülenecek.

Ayrıca, bu, boş notların görüntülendiği sayfadır ancak notlar mevcutsa, o zaman açıkça geri dönüşüm görünümü görüntülenecektir ve eylem çubuğunun üst kısmında bir arama görünümü bulunmaktadır.









Daha sonra burası, notu düzenleyebileceğiniz ve kayan eylem düğmesi aracılığıyla düzenlenen notu kaydedebileceğiniz EditNoteFragment'tir.









Ayrıca eylem çubuğunun üst kısmındaki EditNoteFragment'te bulunan notu da silebilirsiniz.
