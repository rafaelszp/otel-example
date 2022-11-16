JAVA_OPTIONS=-javaagent:/home/rafael/dev/estudos/otel/opentelemetry-javaagent.jar \
             -Dotel.instrumentation.jdbc-datasource.enabled=true \
             -Dotel.instrumentation.common.db-statement-sanitizer.enabled=false \
             -Dotel.instrumentation.hibernate.experimental-span-attributes=true \
             -Dotel.javaagent.debug=false \
             -Dotel.exporter.otlp.endpoint=http://localhost:4317 \
             -Dotel.resource.attributes="service.name=div-calculator" \
             -javaagent:/home/rafael/dev/estudos/otel/glowroot/glowroot.jar \
             -Dglowroot.agent.id=teste::div-calculator \
             -Dglowroot.collector.address=http://10.21.152.139:8181


java.build:
	mvn clean package -DskipTests

java.run:
	OTEL_INSTRUMENTATION_COMMON_DB_STATEMENT_SANITIZER_ENABLED=false java -jar ${JAVA_OPTIONS} target/quarkus-app/quarkus-run.jar