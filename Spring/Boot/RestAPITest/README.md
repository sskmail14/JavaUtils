>Certificate Generation Steps

keytool -genkeypair -alias server-alias1 -keyalg RSA -dname "CN=*.testssl.com,OU=Local,O=Local,L=ED,S=TN,C=IN" -keypass testssl123 -keystore server-keystore.jks -storepass testssl123
keytool -genkeypair -alias client-alias1 -keyalg RSA -dname "CN=*.testssl.com,OU=Local,O=Local,L=ED,S=TN,C=IN" -keypass testssl123 -keystore client-keystore.jks -storepass testssl123

keytool -exportcert -alias client-alias1 -file client-public.cer -keystore client-keystore.jks -storepass testssl123
keytool -importcert -keystore server-truststore.jks -alias clientcert -file client-public.cer -storepass testssl123

keytool -exportcert -alias server-alias1 -file server-public.cer -keystore server-keystore.jks -storepass testssl123
keytool -importcert -keystore client-truststore.jks -alias servercert -file server-public.cer -storepass testssl123


openssl req -new -x509 -keyout testssl-ca1-key.pem -out testssl-ca1.pem -days 365
keytool -import -alias testssl-ca1 -file testssl-ca1.pem -keystore server-truststore.jks -storepass testssl123
keytool -genkeypair -alias client-aliasv1 -keyalg RSA -dname "CN=testssl-client1,OU=Local,O=Local,L=ED,S=TN,C=IN" -keypass testssl123 -keystore client-keystore.jks -storepass testssl123
keytool -keystore client-keystore.jks -certreq -alias client-aliasv1 -keyalg rsa -storepass testssl123 > unsigned-client.csr
openssl x509 -req -CA testssl-ca1.pem -CAkey testssl-ca1-key.pem -in unsigned-client.csr -out signed-client.cer -days 365 -CAcreateserial
keytool -import -keystore client-keystore.jks -file testssl-ca1.pem -alias testssl-ca1 
keytool -import -keystore client-keystore.jks -file signed-client.cer -alias client-aliasv1

keytool -list -v -keystore client-keystore.jks
keytool -export -alias client-alias1 -file cert_client_keytool.crt -keystore client-keystore.jks
keytool -import -alias client-alias1 -file cert_client_keytool.crt  -keystore "%JAVA_HOME%\jre\lib\security\cacerts" -storepass changeit

>Note

Add Host Entry - 127.0.0.1 client.testssl.com

>Certs Info
Country Name (2 letter code) [AU]:IN
State or Province Name (full name) [Some-State]:TN
Locality Name (eg, city) []:ED
Organization Name (eg, company) [Internet Widgits Pty Ltd]:Local
Organizational Unit Name (eg, section) []:Local
Common Name (eg, YOUR name) []:*.testssl.com
Email Address []:test@testssl.com
