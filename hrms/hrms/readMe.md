## HRMS PART1 - SİSTEMDE BULUNAN İŞ POZİSYONLARININ LİSTELENMESİ

Bu kısımda sistemde kayıtlı olan iş pozisyonları yazılan api ile listelenmiştir. Job class'ı ile PostgreSql'de oluşturulan "job_positions" tablosu map edilmiştir. 
job_positions tablosunda 4 adet özellik tutulmaktadır. 

PostgreSql Tablo Sütunlar  - Java Class Mapping 
* job_positon_id            - id
* job_name                  - name
* cdate                     - cdate
* udate                     - udate

Job class'ındaki id özelliği job_positions tablosundaki primary key kolonu ile map edilmiştir. Aşağıdaki kod satırı ile bu mapping yapılmıştır. Class'ın diğer özelliklerinde de
benzer şekilde işlem yapılmıştır.

	@Id
	@GeneratedValue
	@Column(name="job_position_id")
	private int id;

Tabloda bulunan **cdate** ve **udate** alanları postgresql de **TIMESTAMP WITHOUT TIME ZONE** olarak belirtilmiştir. Java'da karşılık olarak bu alanların veri tipi 
**OffsetDateTime** olarak kullanılmıştır. 



Projenin çıktısına output.png görüntüsünden bakabilirsiniz.
