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

##Tutorial 8
### What I have learned today
>ReactJS

### Pertanyaan
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.
> Pertama saya menambahkan props inputType pada List.js. Kemudian saya mengubah input type pada Item.js menjadi {props.inputType}. Lalu menambahkan inputType hidden pada Our Menu di App.js dan AppFunc.js. Hal ini dilakukan agar checkbox pada Our Menu tidak ada. Kemudian menambahkan inputType checkbox pada My favorite agar terdapat checkbox pada My favorite. 
>![Screen Shot 2019-11-13 at 21 18 05](https://user-images.githubusercontent.com/45730367/68771742-2a518e80-065b-11ea-824f-142a2c0eefe5.png)

>![Screen Shot 2019-11-13 at 21 19 24](https://user-images.githubusercontent.com/45730367/68771842-5a992d00-065b-11ea-942c-0b64ef557757.png)

>![Screen Shot 2019-11-13 at 21 20 56](https://user-images.githubusercontent.com/45730367/68771933-874d4480-065b-11ea-9ae4-bf494a279633.png)

>![Screen Shot 2019-11-13 at 21 21 59](https://user-images.githubusercontent.com/45730367/68772035-ae0b7b00-065b-11ea-9c99-9da460c0897d.png)

>Yang kedua saya membuat fungsi handleItemMenuClick pada App.js dan AppFunc.js. Fungsi ini dibuat agar setiap item yang di klik hanya bisa di uncheck di list sebelah kanan. Hal ini dilakukan dengan menghapus else pada function handleItemClick. Kemudian ubah onItemClick menjadi handleItemMenuClick.
>![Screen Shot 2019-11-13 at 21 34 17](https://user-images.githubusercontent.com/45730367/68773016-64239480-065d-11ea-9f9d-8924df3bd493.png)

>![Screen Shot 2019-11-13 at 21 37 50](https://user-images.githubusercontent.com/45730367/68773308-ed3acb80-065d-11ea-9b1b-04aa574408e8.png)

>![Screen Shot 2019-11-13 at 21 36 31](https://user-images.githubusercontent.com/45730367/68773190-b795e280-065d-11ea-93c1-06e91de7ed91.png)

>Yang ketiga, saya membuat checkbox show favorites di App.js. Pertama saya membuat state showFav. Kemudian, saya membuat fungsi untuk menandai state untuk show favorite. Kemudian saya membuat fungsi myFav untuk hide favorites jika checkbox di unchecked.
>![Screen Shot 2019-11-13 at 21 44 25](https://user-images.githubusercontent.com/45730367/68773841-d779d600-065e-11ea-8a88-4684d8f3c427.png)
 
>![Screen Shot 2019-11-13 at 21 45 20](https://user-images.githubusercontent.com/45730367/68774025-1576fa00-065f-11ea-9c47-c4c772f2e86f.png)

>Yang keempat, saya membuat file EmptyState pada folder components. Kemudian, saya import EmptyState di List.js. Lalu, saya import juga di App.js untuk menjalankan pada class based jika list favorit saya kosong. Lalu load showFavnya jika ditambahkan ke list.

>![Screen Shot 2019-11-13 at 21 51 19](https://user-images.githubusercontent.com/45730367/68774491-c41b3a80-065f-11ea-87ea-99d34401fbc3.png)

>>![Screen Shot 2019-11-13 at 21 51 50](https://user-images.githubusercontent.com/45730367/68774841-4572cd00-0660-11ea-8042-0ca778ec6e91.png)

>![Screen Shot 2019-11-13 at 21 52 19](https://user-images.githubusercontent.com/45730367/68774596-edd46180-065f-11ea-981f-ab5bcb16a988.png)

>![Screen Shot 2019-11-13 at 21 52 54](https://user-images.githubusercontent.com/45730367/68774652-004e9b00-0660-11ea-9c6b-949a44f9aaba.png)


##Tutorial 9
### What I have learned today
>Http request in React & menyambungkan frontend(react) dan backend(gopud application)

### Pertanyaan

1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut?
> Saya menambahkan  this.setState({nama: " ", alamat: " ", nomorTelepon: " ", rating: " "}); pada bagian async addRestoran di Restorans.js agar setiap kali ingin add restoran isi kotak form akan tetap dalam kondisi kosong.
>![Screen Shot 2019-11-29 at 13 29 57](https://user-images.githubusercontent.com/45730367/69848324-649e6b00-12ac-11ea-8d15-cb00c13b109f.png)
2. Jelaskan fungsi dari async dan await!
> Fungsi async dapat berisi ekspresi await yang menghentikan sementara eksekusi fungsi async dan menunggu resolusi Promise yang disahkan, dan kemudian melanjutkan eksekusi fungsi async dan mengembalikan nilai yang diselesaikan.Await hanya valid di dalam fungsi async.
3. Masukkan jawaban dari TODO (Screenshot) pada Component Lifecycle pada pertanyaan ini.
> ![1](https://user-images.githubusercontent.com/45730367/69856976-70485c80-12c1-11ea-9061-47627bdfee53.png)
>
> ![Screen Shot 2019-11-27 at 10 55 19](https://user-images.githubusercontent.com/45730367/69857645-f31de700-12c2-11ea-8649-3fc4f865dd66.png)
>
>![Screen Shot 2019-11-27 at 11 41 03](https://user-images.githubusercontent.com/45730367/69857870-5f98e600-12c3-11ea-97a4-4c418bd3eab8.png)
> 
>![Screen Shot 2019-11-27 at 11 41 39](https://user-images.githubusercontent.com/45730367/69857882-64f63080-12c3-11ea-9171-fc341b41cd92.png)
>
> ![Screen Shot 2019-11-27 at 11 01 29](https://user-images.githubusercontent.com/45730367/69857551-c5d13900-12c2-11ea-86d4-bb3632452eb0.png)
>
>![Screen Shot 2019-11-27 at 11 42 21](https://user-images.githubusercontent.com/45730367/69858036-bef6f600-12c3-11ea-8ea3-19ba4f15c861.png)
>
>![Screen Shot 2019-11-27 at 11 45 39](https://user-images.githubusercontent.com/45730367/69858105-e221a580-12c3-11ea-8897-0c07018ef73d.png)
>
>![Screen Shot 2019-11-27 at 14 13 17](https://user-images.githubusercontent.com/45730367/69858145-f9609300-12c3-11ea-96f6-20a1344ca080.png)
>
>![Screen Shot 2019-11-27 at 14 34 03](https://user-images.githubusercontent.com/45730367/69858247-2e6ce580-12c4-11ea-9dd1-49d63b0838c5.png)
>
>![Screen Shot 2019-11-27 at 14 37 01](https://user-images.githubusercontent.com/45730367/69858316-54928580-12c4-11ea-94fa-07228d9a83d4.png)
>
>![Screen Shot 2019-11-27 at 15 21 10](https://user-images.githubusercontent.com/45730367/69858401-80157000-12c4-11ea-9731-f1e6b371433c.png)
>
>![Screen Shot 2019-11-27 at 16 25 07](https://user-images.githubusercontent.com/45730367/69858456-9f140200-12c4-11ea-8fac-24d82e5892c7.png)
>
>![Screen Shot 2019-11-27 at 16 28 14](https://user-images.githubusercontent.com/45730367/69858507-bbb03a00-12c4-11ea-9daf-b4907bb117c3.png)
>
>![Screenshot (154)](https://user-images.githubusercontent.com/45730367/69859837-8e18c000-12c7-11ea-9efe-22c659734286.png)
>
>![Screen Shot 2019-11-29 at 16 30 27](https://user-images.githubusercontent.com/45730367/69859889-a8529e00-12c7-11ea-9eec-a91359be0679.png)
>
>![Screen Shot 2019-11-29 at 16 29 10](https://user-images.githubusercontent.com/45730367/69858826-6cb6d480-12c5-11ea-92c9-1a3bc8f3f96f.png)
>
>![Screen Shot 2019-11-29 at 17 09 49](https://user-images.githubusercontent.com/45730367/69861527-219fc000-12cb-11ea-90c7-1bd9675ccd44.png)
>
>![Screen Shot 2019-11-28 at 19 11 06](https://user-images.githubusercontent.com/45730367/69875611-2aef5380-12f0-11ea-8a14-27bada4ff13a.png)
>
>![Screen Shot 2019-11-28 at 19 11 13](https://user-images.githubusercontent.com/45730367/69875613-2aef5380-12f0-11ea-95b2-45640f33707b.png)
>
>![Screen Shot 2019-11-28 at 19 11 22](https://user-images.githubusercontent.com/45730367/69875614-2b87ea00-12f0-11ea-8658-a3fc57b3e69a.png)
>
>![Screen Shot 2019-11-28 at 19 11 32](https://user-images.githubusercontent.com/45730367/69875615-2c208080-12f0-11ea-9238-c91c5f1f6a8b.png)
>
>![Screen Shot 2019-11-28 at 19 11 49](https://user-images.githubusercontent.com/45730367/69875616-2c208080-12f0-11ea-9e01-e92a15c54afa.png)
>
>![Screen Shot 2019-11-28 at 19 12 01](https://user-images.githubusercontent.com/45730367/69875617-2cb91700-12f0-11ea-9003-3ad432864292.png)
>
>![Screen Shot 2019-11-28 at 19 15 32](https://user-images.githubusercontent.com/45730367/69875618-2cb91700-12f0-11ea-8bda-fa6df60237c0.png)
>
>![Screen Shot 2019-11-28 at 19 20 06](https://user-images.githubusercontent.com/45730367/69875620-2d51ad80-12f0-11ea-859a-4fa0971d2bdf.png)
>
>![Screen Shot 2019-11-29 at 21 38 42](https://user-images.githubusercontent.com/45730367/69875839-a5b86e80-12f0-11ea-8434-1bbad3b1dd2c.png)
>
>![Screen Shot 2019-11-28 at 19 27 19](https://user-images.githubusercontent.com/45730367/69875945-e57f5600-12f0-11ea-98dc-22624f1296e6.png)
>
>![Screen Shot 2019-11-28 at 19 27 24](https://user-images.githubusercontent.com/45730367/69875989-0778d880-12f1-11ea-908f-df4a53b2b113.png)
>![Screen Shot 2019-11-28 at 19 30 02](https://user-images.githubusercontent.com/45730367/69876051-355e1d00-12f1-11ea-81c8-de651a152198.png)
>
>![Screen Shot 2019-11-28 at 19 39 03](https://user-images.githubusercontent.com/45730367/69876055-368f4a00-12f1-11ea-9234-a8607bb209c9.png)
>
>![Screen Shot 2019-11-28 at 20 40 25](https://user-images.githubusercontent.com/45730367/69876056-368f4a00-12f1-11ea-8865-01cecc401662.png)
>
> ![Screen Shot 2019-11-28 at 20 48 07](https://user-images.githubusercontent.com/45730367/69876057-3727e080-12f1-11ea-936c-14c5cf14c5cb.png)
>
 >![Screen Shot 2019-11-28 at 20 49 56](https://user-images.githubusercontent.com/45730367/69876058-3727e080-12f1-11ea-8db6-65c96ed3d449.png)
>
> ![Screen Shot 2019-11-28 at 20 50 01](https://user-images.githubusercontent.com/45730367/69876061-37c07700-12f1-11ea-9d78-fe31263eb143.png)
>
> ![Screen Shot 2019-11-28 at 20 51 32](https://user-images.githubusercontent.com/45730367/69876064-37c07700-12f1-11ea-9715-00bbba7803f5.png)
>
> ![Screen Shot 2019-11-28 at 22 10 39](https://user-images.githubusercontent.com/45730367/69876065-38590d80-12f1-11ea-8c72-07d8247dd7be.png)
>
 >![Screen Shot 2019-11-28 at 22 17 07](https://user-images.githubusercontent.com/45730367/69876068-38f1a400-12f1-11ea-996b-feaf9d07c96e.png)
>
 >![Screen Shot 2019-11-28 at 22 17 13](https://user-images.githubusercontent.com/45730367/69876069-38f1a400-12f1-11ea-8985-68e26e06a8b2.png)
>
 >![Screen Shot 2019-11-28 at 22 21 20](https://user-images.githubusercontent.com/45730367/69876070-398a3a80-12f1-11ea-9d10-9ad895378c40.png)
>
 >![Screen Shot 2019-11-28 at 22 21 35](https://user-images.githubusercontent.com/45730367/69876071-398a3a80-12f1-11ea-8b69-79c1d215485d.png)
>
 >![Screen Shot 2019-11-28 at 22 22 18](https://user-images.githubusercontent.com/45730367/69876074-3abb6780-12f1-11ea-8b4f-195e50058838.png)
>
 >![Screen Shot 2019-11-28 at 23 49 51](https://user-images.githubusercontent.com/45730367/69876075-3abb6780-12f1-11ea-9563-faa3ebef72a2.png)
>
 >![Screen Shot 2019-11-28 at 23 49 59](https://user-images.githubusercontent.com/45730367/69876077-3b53fe00-12f1-11ea-8fd5-189e312fb679.png)
>
 >![Screen Shot 2019-11-28 at 23 50 14](https://user-images.githubusercontent.com/45730367/69876078-3b53fe00-12f1-11ea-909b-572a7e9de052.png)
>
 >![Screen Shot 2019-11-28 at 23 50 24](https://user-images.githubusercontent.com/45730367/69876081-3bec9480-12f1-11ea-80b5-87d27c64b742.png)
>
 >![Screen Shot 2019-11-29 at 21 43 34](https://user-images.githubusercontent.com/45730367/69876141-63dbf800-12f1-11ea-84d2-5fb432268fe1.png)
>
 >![Screen Shot 2019-11-29 at 21 43 45](https://user-images.githubusercontent.com/45730367/69876142-64748e80-12f1-11ea-91b4-f942e7e330ed.png)


4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate, componentDidUpdate, componentWillReceiveProps, componentWillUnmount.
Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja yang biasanya menggunakan lifecycle method tersebut”.
> componentDidMount dipanggil segera setelah komponen di-mount. Inisialisasi yang memerlukan node DOM harus pergi di sini. Jika perlu memuat data dari titik akhir jarak jauh, ini adalah tempat yang baik untuk membuat instantiate permintaan jaringan.
> shouldComponentUpdate digunakan untuk memberi tahu React jika output komponen tidak terpengaruh oleh perubahan saat ini dalam status atau properti. Perilaku default adalah untuk me-render ulang pada setiap perubahan state, dan dalam sebagian besar kasus harus bergantung pada default behaviour.
> componentDidUpdate dipanggil segera setelah update terjadi. Metode ini tidak dipanggil untuk render awal. Metode ini digunakan sebagai peluang untuk beroperasi pada DOM ketika komponen telah di-update. Ini juga merupakan tempat yang baik untuk melakukan permintaan jaringan selama membandingkan current props dengan previous props.
> componentWillUpdate dipanggil tepat sebelum rendering saat props atau state baru diterima. Metode ini digunakan sebagai kesempatan untuk melakukan persiapan sebelum update terjadi. Metode ini tidak dipanggil untuk render awal.
> componentWillUnmount dipanggil segera sebelum component di-unmounted dan di-destroyed. Lakukan cleanup apa pun yang diperlukan dalam metode ini, seperti timer yang tidak valid, membatalkan network requests, atau membersihkan subscription apa pun yang dibuat di componentDidMount().