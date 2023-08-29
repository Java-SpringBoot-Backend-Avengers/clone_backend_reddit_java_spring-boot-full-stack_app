plugins {
	java
	id("org.springframework.boot") version "2.7.15"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "com.sbj"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
	targetCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

/**
 * implementation: dependencies required (and available) by/for the main source-code for both development/compiler and runtime. These dependencies are included in the classpath of the complied code available during both compile time and runtime
 *
 * testImplementation: dependencies required only during testing. These dependencies are included in the classpath when running tests. These dependencies are testing frameworks, assertion libraries and other tools required for testing the code
 *
 * developmentOnly: dependencies required only during development and not the runtime. Dependencies in this configuration are not included in the distribution of the application code artifacts. Dependencies in this configuration serve purposes such as code analysis, debugging or generating documentation
 *
 * runtimeOnly: dependencies required at runtime but not necessarily during compile time. Dependencies in this configuration provides functionality for only when application is running such as plugins, drivers or dynamically loaded modules
 */
dependencies {
	// spring dependencies
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

	// lombok
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	// JWT authentication
	implementation("io.jsonwebtoken:jjwt-api:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.11.5")

	// database
	runtimeOnly("org.postgresql:postgresql")

	// show time span
	implementation("com.github.marlonlom:timeago:4.0.0")

	// test dependencies
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
