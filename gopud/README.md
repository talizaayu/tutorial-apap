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