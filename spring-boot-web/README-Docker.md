# 使用dockerfile 构建image

docker build . -t springboot-docker docker run --rm -d --name springboot-docker -p 8080:8080 springboot-docker

# 直接运行 jar

docker run -it --rm --name springboot-docker -p 8080:8080 -v C:
\WQDoc\IdeaProjects\qiang\spring-boot-docker\target\spring-boot-docker-0.0.1-SNAPSHOT.jar:/app.jar eclipse-temurin:
17-jre-alpine java -jar /app.jar

# maven 构建

docker volume create --name maven-repo docker run -it --rm -v C:\WQDoc\IdeaProjects\qiang\spring-boot-docker:/app -v
maven-repo:/root/.m2 -w /app maven mvn clean package -T 4C -DskipTests=true

docker run -it --rm -v C:\WQDoc\IdeaProjects\qiang\spring-boot-docker:/app -v "$HOME/.m2":/root/.m2 -w /app maven mvn
clean package -T 4C -DskipTests=true