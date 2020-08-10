# omdbapi-test
Tested using Rest Assured library in Java

http://www.omdbapi.com/ adresindeki public api'yi kullanarak aşağıdaki case'i oluşturdum.

Senaryo

1. "By Search" başlığı altındaki parametrelerle "Harry Potter" araması yapıp,gelen sonuçlardan "Harry Potter and the Sorcerer's Stone" filminin id'sini almak.

2. Bu id ile "By ID or Title" başlığı altındaki metodlarda film araması yapmak.

3. Gelen response alanınının boş gelip gelmediğini ve http status kodunu kontrol etmek.
