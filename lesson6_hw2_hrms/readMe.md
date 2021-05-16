## **HRMS DİAGRAM VE TABLO AÇIKLAMALAR**

#### users: 
Açıklama    : users tablosu HRMS (Human Resources Management System) veri tabanındaki kullanıcıların base tablosudur. Sistemde bulunan 3 tip kullanıcı türü 
* iş arayan (candidates)
* iş veren  (employers)
* sistem personeli (system_employees)

Tabloda yer alan email kolonu ve msisdn (Mobile Station International Subscriber Directory Number) kolonu unique'dir. Yani 1 maile ya da 1 telefon numarasına karşılık
sadece 1 kullanıcı bulunabilir. cdate kolonu bu tabloya kayıt atıldığı andaki tarihtir (timestamp without timezon). udate kolunu ise tabloda güncelleme yapıldığı zaman
kayıt atılması gereken yerdir.

#### candidates:
Açıklama    : candidates tablosu sistemde iş arayan kullanıcıların bulunduğu tablodur. users tablosunda bulunan user_id kolonu ile 1'e 1 ilişkiye sahiptir. Yani candidates
tablosunda bulunan bir adaydan users tablosunda sadece 1 adet bulunur. candidates tablosunda bulunan nat_id kolonu kimlik numarasına karşılık gelir ve unique bir değerdir.

#### employers:
Açıklama    : employers tablosu iş verenlerin kaydının atıldığı tablodur. Diğer kullanıcı türleri gibi users tablosu ile 1'e 1 ilişkiye sahiptir ve users tablosu ile 
CASCADE bir delete ilişkisine sahiptir. Yani users tablosunda bulunan bir kayıt silinirse bu tablodan da otomatik silinir.

#### system_employees:
Açıklama    : Bu tablo hrms sistemine ait çalışan personellerin bulunduğu tablodur. 

#### job_positions:
Açıklama    : İş pozisyonları bu tabloda bulunur ve unique değere sahiptir.

#### activation_codes ve diğer tablolar:
Açıklama    : Sistemdeki kullanıcılara ait doğrulama kodlarının bulunduğu onayların yapıldığı tablolardır.
