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
>th:object berfungsi untuk menentukan objek yang terhubung dengan form data yang dikirimkan dan tujuannya adalah untuk select an object. Atribut th:object merupakan referensi Model key yang mereferensikan Command object atau form bean yang merepresentasikan state dari form. Tujuan dari th:object adalah untuk select an object.

### What I did not understand
>Kegunaan attribute di thymeleaf

---
## Tutorial 5
### What I have learned today
>1. Unit testing
>2. Code coverage

### Code Coverage
> * MenuServiceImplTest
>> Sebelum
>> ![Screen Shot 2019-10-10 at 22 14 29](https://user-images.githubusercontent.com/45730367/66582127-75373c80-ebab-11e9-806e-7a75ba27c388.png)
>> Sesudah
>> ![Screen Shot 2019-10-10 at 22 17 30](https://user-images.githubusercontent.com/45730367/66582327-ca734e00-ebab-11e9-9813-1052294eb607.png)
> * RestoranControllerTest
>> Sebelum
>> ![Screen Shot 2019-10-10 at 14 40 38](https://user-images.githubusercontent.com/45730367/66581620-9ba8a800-ebaa-11e9-924c-de81baccf52c.png)
>> Sesudah
>> ![Screen Shot 2019-10-10 at 22 10 23](https://user-images.githubusercontent.com/45730367/66581712-cabf1980-ebaa-11e9-9c5d-38da1e564f21.png)
> * Konfigurasi main class
>> Sebelum
>> ![Screen Shot 2019-10-09 at 21 12 00](https://user-images.githubusercontent.com/45730367/66582460-08707200-ebac-11e9-94f3-abd2f6ad2f05.png)
>> Sesudah
>> ![Screen Shot 2019-10-10 at 22 19 49](https://user-images.githubusercontent.com/45730367/66582515-2211b980-ebac-11e9-98e9-5ba243ed0a48.png)

### Pertanyaan
Jelaskan bagian mana saja dari test yang dibuat pada latihan no 2 adalah given, when, dan and then.
>* Given
>> Terjadi saat mendefinisikan apa yang seharusnya dikembalikan database
>>![Screen Shot 2019-10-10 at 21 49 15](https://user-images.githubusercontent.com/45730367/66580018-ed9bfe80-eba7-11e9-8fb3-ec57df9ba7b6.png)
>* When
>> Kondisi dan interaksi apa yang akan di-test
>> ![Screen Shot 2019-10-10 at 21 52 13](https://user-images.githubusercontent.com/45730367/66580226-410e4c80-eba8-11e9-9fa4-bc055a869468.png)
>* Then
>> Terjadi saat pendefinisian hasil interaksi kode yang diharapkan
>> ![Screen Shot 2019-10-10 at 21 54 03](https://user-images.githubusercontent.com/45730367/66580377-829ef780-eba8-11e9-8f30-1eefbcbb187f.png)

Jelaskan perbedaan line coverage dan logic coverage.
>Line coverage mengukur berapa banyak pernyataan yang diambil. Pernyataan biasanya berupa baris kode, tidak termasuk komentar, kondisional, dll. Line coverage menguji kode per-baris. Sedangkan, Logic Coverage melakukan pengujian pada struktur internal kode yang berupa logical expressions yang ada pada kode. Logic coverage menguji decision yang terdapat pada program.
>
Pada keadaan ideal, apa yang seharusnya dibuat terlebih dahulu, code atau unit test? Mengapa seperti itu? Apa akibatnya jika urutannya dibalik, adakah risiko tak terlihat yang mungkin terjadi?
>Untuk keadaan ideal yang harus dibuat terlebih dahulu adalah unit test. Unit test dibuat terlebih dahulu karena jika implementasi kode ingin diubah, tidak harus mengubah behaviour seluruh kode. Jika terdapat kode baru yang ditambahkan kemudian menimbulkan error, tidak perlu dikhawatirkan karena unit test untuk bagian kode tersebut sudah dibuat dan berhasil dijalankan. Jika urutan dibalik, risiko yang terjadi adalah kemungkinan kode yang dibuat terdapat error sehingga membutuhkan waktu yang lebih untuk membenarkan dan meng-handle error pada kode.
>
[Bonus] Jelaskan mengapa pada latihan no 3, main class spring tidak diikutsertakan ke dalam perhitungan coverage? Apa saja yang dapat menyebabkan suatu class dapat di-exclude dari perhitungan code coverage.
> Main class spring tidak diikutsertakan ke dalam perhitungan coverage karena main class method merupakan class yang tidak dihitung coverage nya, sehingga akan mengurangi total dari penghitungan coverage. Hal yang dapat menyebabkan suatu class dapat di-exclude dari perhitungan code coverage adalah file built-in dan file yang mempunyai code coverage rendah dan akan mengakibatkan pengurangan coverage secara keseluruhan. Kemudian, file configuration yang tidak terdapat proses didalamnya. 

### What I did not understand
>The testing syntax
>

## Tutorial 6
### What I have learned today
>1. Web service
>2. Postman

### Pertanyaan
1. Apa itu postman? Apa kegunaan dari postman?
> Postman adalah platform kolaborasi untuk pengembangan API. Fitur Postman menyederhanakan setiap langkah membangun API dan merampingkan kolaborasi sehingga dapat membuat API yang lebih baik dan cepat. Postman dapat digunakan untuk membuat berbagai jenis request HTTP yaitu GET, POST, PUT, PATCH dan DELETE. Postman memiliki fitur Variables, Pre-Request Script, Environments, dan Tests.
2. Apa kegunaan dari annotation @JsonIgnoreProperties?
> @JsonIgnoreProperties merupakan anotasi yang dapat digunakan untuk menekan serialisasi properti (selama serialisasi), atau mengabaikan pemrosesan properti JSON yang dibaca (saat deserialisasi)
3. Apa itu ResponseEntity dan apa kegunaannya?
>ResponseEntity mewakili seluruh respons HTTP: status code, headers, dan body. Karena itu, ResponseEntity dapat menggunakannya untuk mengkonfigurasi respons HTTP sepenuhnya. Jika kita ingin menggunakannya, kita harus mengembalikannya dari titik akhir kemudian Spring mengurus sisanya. ResponseEntity adalah generic type.

### What I did not understand
>1. Rest

##Tutorial 7
### What I have learned today

### Pertanyaan
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?
> Dalam proses otentikasi, identitas pengguna diperiksa untuk memberikan akses ke sistem, pengguna atau orang diverifikasi, kemudian biasanya membutuhkan detail login pengguna, serta dapat menentukan apakah orang tersebut pengguna atau bukan. Proses otentikasi juga dilakukan sebelum proses otorisasi.
Sedangkan dalam proses otorisasi, otoritas orang atau pengguna diperiksa untuk mengakses sumber daya, pengguna atau orang divalidasi, membutuhkan tingkat hak istimewa atau keamanan pengguna, serta menentukan izin apa yang dimiliki pengguna. Proses otorisasi juga dilakukan setelah proses otentikasi.
>>Otentikasi (di package security file WebSecurityConfig.java)
>![Screen Shot 2019-11-06 at 21 49 04](https://user-images.githubusercontent.com/45730367/68308395-632fb780-00df-11ea-8438-9e14766f98c7.png)
>Pada bagian ini diharapkan user sudah terotentikasi
>>>Otorisasi (di package security file WebSecurityConfig.java)
>![Screen Shot 2019-11-06 at 21 52 34](https://user-images.githubusercontent.com/45730367/68308634-cae60280-00df-11ea-87c3-dcc7724ad46b.png)
>Pada bagian ini hanya user memiliki otorisasi admin yang dapat mengaksesnya
2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerjanya!
>Bycrpt secara internal akan menghasilkan random salt. Maksudnya adalah setiap panggilan akan memiliki hasil yang berbeda, jadi hanya perlu menyandikan kata sandi sekali. Algoritma BCrypt menghasilkan String dengan panjang 60, jadi perlu dipastikan bahwa password akan disimpan dalam kolom yang dapat menampungnya. Kesalahan umum adalah membuat kolom dengan panjang yang berbeda kemudian mendapatkan kesalahan nama user atau invalid password pada waktu otentikasi.
BCryptPasswordEncoder secara otomatis menghasilkan dan menggunakan random salt untuk menghitung hash, itu sebabnya setiap kali di-call akan mendapatkan output yang berbeda. Contohnya jika dihasilkan 10 hash dalam satu lingkaran, semuanya akan berbeda dan valid.
Cara kerja bycrpt : "Generate a random salt. A "cost" factor has been pre-configured. Collect a password."
>Pertama, memperoleh encryption key dari salt dan cost factor. Salt dan cost factor digunakan untuk encrypt string yang well-known. Kemudian, simpan cost, salt, dan cipher text. Karena ketiga elemen ini memiliki panjang yang diketahui, mudah untuk menggabungkannya dan menyimpannya dalam satu field, dan nantinya akan dapat dipisahkan. Ketika seseorang mencoba mengautentikasi, ambil salt dan cost yang tersimpan kemudian derive key dari input password, cost, dan salt lalu encrypt string yang well-known yang sama. Jika chiper text yang dihasilkan cocok dengan chiper text yang tersimpan, maka passwordnya match.
3. Jelaskan secara singkat apa itu UUID dan mengapa kita memakai UUID di UserModel.java?
>A universally unique identifier (UUID) adalah adalah nomor 128-bit yang mengidentifikasi objek atau data Internet yang unik. UUID dihasilkan oleh algoritma dengan values yang didasarkan pada network address mesin. UUID digunakan di UserModel.java untuk
4. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?
>UserDetailsServiceImpl adalah antarmuka inti dalam kerangka kerja Spring Security. UserDetailsServiceImpl digunakan untuk mengambil informasi otentikasi dan otorisasi pengguna. Class tersebut memiliki metode loadUserByUsername() yang dapat diganti untuk menyesuaikan proses menemukan pengguna. Ini digunakan oleh DaoAuthenticationProvider untuk memuat detail tentang pengguna selama otentikasi.
