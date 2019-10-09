# Tutorial APAP
## Authors
* **taliza.ayu** - *1706024715* - *B*

---
## Tutorial 2
Pertanyaan 1: Cobalah untuk menambahkan sebuah restoran dengan mengakses link
berikut:
http://localhost:8080/restoran/add?idRestoran=1&nama=PanyuFC&alamat=Kantin%2
0Fasilkom&nomorTelepon=14022
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.

>Terjadi error karena pada tahap ini karena folder template belum diisi. File html yang di return di file RestoranController.java belum dibuat.

Pertanyaan 2: Cobalah untuk menambahkan sebuah restoran dengan mengakses link
berikut:
http://localhost:8080/restoran/add?idRestoran=2&nama=KentukuFC&alamat=Kantin
%20FIK
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.

>Terjadi error karena karena parameter 'nomorTelepon' tidak tertulis di link diatas.

Pertanyaan 3: Jika Papa APAP ingin melihat restoran PanyuFC, link apa yang harus
diakses?

>http://localhost:8080/restoran/view?idRestoran=1

Pertanyaan 4: Tambahkan 1 contoh restoran lainnya sesukamu. Lalu cobalah untuk
mengakses http://localhost:8080/restoran/viewall, apa yang akan ditampilkan? Sertakan
juga bukti screenshotmu.

>https://user-images.githubusercontent.com/45730367/65155268-30f6c780-da57-11e9-8bad-715800311c0b.png

---
## Tutorial 3
### What I have learned today
>Menggunakan JPA Repository
>Menggunakan XMAPP untuk menyambungkan dengan mysql database
>Mengimplementasikan Object Relational Model

#### Pertanyaan
1. Pada class MenuDb, terdapat method findByRestoranIdRestoran, apakah kegunaan dari method tersebut?
> Kegunaan method findByRestoranIdRestoran pada MenuDB adalah untuk mencari menu berdasarkan id restoran nya.

2. Pada class RestoranController, jelaskan perbedaan method addRestoranFormPage dan addRestoranSubmit?
>Method addRestoranFormPage berfungsi untuk menampilkan halaman yang berisi form add restoran yaitu halaman untuk mengisi data restoran yang ingin ditambahkan sedangkan method addRestoranSubmit berfungsi untuk menampilkan halaman yang memberi informasi bahwa restoran yang ditambahkan telah berhasil. Method addRestoranFormPage menggunakan request method get karena ingin mengambil data yang di isi sedangkan method addRestoranSubmit menggunakan request method post karena data yang disubmit ingin ditampilkan di halaman bahwa data tersebut telah berhasil untuk disubmit.

3. Jelaskan apa kegunaan dari JPA Repository?
>JPA Repository menyediakan fungsi CRUD, metode untuk melakukan pagination dan mengurutkan records, serta menyediakan metode flushing the persistence dan menghapus records dalam satu batch. Contoh JPA repository yang digunakan pada tutorial 3 ini adalah mengurutkan nama restoran pada fitur view all restoran kemudian membuat fitur menambah, menghapus, serta mengubah restoran dan menu. Fungsi repository adalah untuk melakukan query terhadap basis data, dan JPA merupakan salah satu framework yang dapat digunakan untuk mengimplementasikan Object Relational Model terhadap database mysql.

4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara RestoranModel dan MenuModel dibuat?
>Relasi antara RestoranModel dan MenuModel dibuat pada kode bagian file MenuModel seperti gambar dibawah. Pada bagian ini mengimplementasikan relasi many to one dimana restoran dapat memiliki banyak menu dan menu hanya dapat dimiliki oleh satu restoran.
https://user-images.githubusercontent.com/45730367/65688067-a0db0280-e094-11e9-922b-fb5ba620fb51.png

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
>FetchType.LAZY adalah tipe pengambilan default untuk semua hibernate annotation relationships. Semua to-many relationships menggunakan FetchType.LAZY. LAZY adalah ketika isi daftar yang diambil hanya ketika Anda mencoba mengaksesnya.
>CascadeType.ALL adalah singkatan untuk semua operasi cascade. Semua operasi cascade akan diterapkan ke parent entity’s related entity. Semua setara dengan menentukan cascade DETACH, MERGE, PERSIST, REFRESH, REMOVE.
>FetchType.EAGER akan secara default memuat semua hubungan yang terkait dengan objek tertentu yang dimuat oleh hibernate. Semua to-one relationships menggunakan FetchType.EAGER. EAGER adalah ketika semua koleksi nya diambil sepenuhnya (fully fetched) pada saat parent nya diambil.

### What I did not understand
>Penggunaan port pada XAMPP
>Annotation pada JPA

---
## Tutorial 4
### What I have learned today
>Thymleaf
>Fragment

Jawablah pertanyaan dibawah ini pada file readme.
1. Jelaskan yang anda pelajari dari melakukan latihan nomor 2, dan jelaskan tahapan bagaimana anda menyelesaikan latihan nomor 2
>Yang saya pelajari dari latihan nomor 2 adalah membuat navigation bar menjadi dinamis sehingga judul navabar di setiap halaman sesuai dengan halaman yang sedang diakses. Cara menyelesaikan latihan nomor 2 adalah dengan menambahkan th:text="${pageTitle} pada file fragment dan menambahkan (pageTitle='nama_halaman') pada setiap implementasi fragment di html. Hal ini dilakukan agar judul navbar akan terganti sesuai dengan pageTitle yang diakses.

2. Jelaskan yang anda pelajari dari latihan nomor 3, dan jelaskan tahapan bagaimana anda menyelesaikan latihan nomor 3
>Yang saya pelajari dari latihan nomor 3 adalah mengimplementasikan expression iteration. Cara menyelesaikan latihan nomor 3 adalah dengan menambahkan method untuk add row dan delete row pada Menu Controller serta mengedit file html form add menu. Selain itu, di Menu Controller mengimplementasikan ArrayList untuk menyimpan menu model di dalam ArrayList. Hal ini dilakukan untuk mengiterasikan isi list yang sudah dibuat untuk submit list yang diisi. Expression iteration dan page title diimplementasikan di file html form add menu untuk menampilkan tabel isi menu.

3. Jelaskan perbedaan th:include dan th:replace
th:include berati akan memasukkan konten yang ada di fragments kedalam tag hostnya, sedangkan th:replace digunakan untuk mengubah tag menjadi tag yang di define oleh fragment. Sedangkan, th:replace berfungsi untuk memasukkan fragmen yang ditentukan sebagai badan dari tag hostnya tetapi tidak termasuk tag fragmen sedangkan th:replace berfungsi untuk mengganti tag host dengan fragmen yang berarti menghapus tag host dan sebagai pengganti tag host, itu akan menambahkan fragmen yang ditentukan termasuk tag fragmen.

4. Jelaskan bagaimana penggunaan th:object beserta tujuannya
>th:object berfungsi untuk menentukan objek yang terhubung dengan form data yang dikirimkan dan tujuannya adalah untuk select an object. 

th:object digunakan untuk menentukan objek yang terhubung dengan form data yang dikirimkan, cara penggunaannya ...

Atribut th:object merupakan referensi Model key yang mereferensikan Command object atau form bean yang merepresentasikan state dari form. Tujuan dari th:object adalah untuk select an object.

### What I did not understand
>Kegunaan attribute di thymeleaf