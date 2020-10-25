### Apache Kafka
## Instalación de Apache Kafka
* Instalar Java 8
* Descargar ultima versión estable de Apache Kafka https://kafka.apache.org/downloads
## Configuración de variables de entorno
# Windows
* JAVA_HOME=<JAVA_DIR>
* KAFKA_HOME=<KAFKA_DIR>
* PATH=%JAVA_HOME%\bin;%KAFKA_HOME%\bin\windows;
# Linux
* JAVA_HOME=<JAVA_DIR>
* KAFKA_HOME=<KAFKA_DIR>
* PATH=%JAVA_HOME%\bin;%KAFKA_HOME%\bin\windows;
## Comandos Kafka:
# Windows
* bin\windows\zookeeper-server-start.bat config\zookeeper.properties (Iniciar servidor zookeeper)
* bin\windows\kafka-server-start.bat config\server.properties (iniciar broker kafka)
* kafka-topics.bat --bootstrap-server localhost:9092 --create --topic crisda24-topic --partitions 40 --replication-factor 1 (Crear topic)
* kafka-topics.bat --list --bootstrap-server localhost:9092 (Listar topics)
# Linux
* bin/zookeeper-server-start. sh conf ig/zookeeper.properties
* bin/kaf ka-server-start.shconf ig/server.properties
* bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic crisda24-topic --partitions 40 --replication-factor 1
* kafka-topics.sh --list --bootstrap-server localhost:9092

