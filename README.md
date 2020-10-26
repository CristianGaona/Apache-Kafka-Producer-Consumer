# Apache Kafka :loudspeaker:
Apache Kafka es una plataforma distribuida de transmisión de datos que permite publicar, almacenar y procesar flujos de registros, y suscribirse a ellos, en tiempo real. Está diseñada para manejar flujos de datos de varias fuentes y distribuirlos a los diversos usuarios. En resumen, transfiere cantidades enormes de datos, no solo desde el punto A hasta el B, sino también del punto A al Z y a cualquier otro lugar que necesite, y todo al mismo tiempo.

Apache Kafka es la alternativa a un sistema de mensajería empresarial tradicional. Comenzó como un sistema interno que LinkedIn desarrolló para manejar 1.4 billones de mensajes por día. Ahora, es una solución open source de transmisión de datos con aplicaciones para diversas necesidades empresariales.

## Documentación :notebook:
* https://kafka.apache.org/documentation/
* https://kafka.apache.org/documentation/#quickstart
## Instalación de Apache Kafka :inbox_tray:
* Instalar Java 8
* Descargar ultima versión estable de Apache Kafka https://kafka.apache.org/downloads
## Configuración de variables de entorno :hammer:
### Windows
* JAVA_HOME=<JAVA_DIR>
* KAFKA_HOME=<KAFKA_DIR>
* PATH=%JAVA_HOME%\bin;%KAFKA_HOME%\bin\windows;
### Linux
* JAVA_HOME=<JAVA_DIR>
* KAFKA_HOME=<KAFKA_DIR>
* PATH=%JAVA_HOME%\bin;%KAFKA_HOME%\bin\windows;
## Comandos Kafka :newspaper:
### Windows
* bin\windows\zookeeper-server-start.bat config\zookeeper.properties (Iniciar servidor zookeeper)
* bin\windows\kafka-server-start.bat config\server.properties (iniciar broker kafka)
* kafka-topics.bat --bootstrap-server localhost:9092 --create --topic crisda24-topic --partitions 5 --replication-factor 1 (Crear topic)
* kafka-topics.bat --list --bootstrap-server localhost:9092 (Listar topics)
kafka-topics.bat --describe --topic crisda24-topic --bootstrap-server localhost:9092 (especificación)
*  bin\windows\kafka-console-consumer.bat --topic crisda24-topic --from-beginning --bootstrap-server localhost:9092 --property print.key=true --property key.separator="-"
*  bin/kafka-console-producer.bat --topic crisda24-topic --bootstrap-server localhost:9092
### Linux
* bin/zookeeper-server-start.sh config/zookeeper.properties
* bin/kaf ka-server-start.sh config/server.properties
* bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic crisda24-topic --partitions 40 --replication-factor 1
* kafka-topics.sh --list --bootstrap-server localhost:9092
* kafka-topics.sh --describe --topic crisda24-topic --bootstrap-server localhost:9092
*  bin/kafka-console-consumer.bat --topic crisda24-topic --from-beginning --bootstrap-server localhost:9092 --property print.key=true --property key.separator="-"
*  bin\windows\kafka-console-producer.bat --topic crisda24-topic --bootstrap-server localhost:9092

