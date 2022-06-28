import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.0"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("com.oracle.database.jdbc:ojdbc8:19.3.0.0")
    implementation("com.oracle.database.jdbc:ucp:19.3.0.0")

	val ociSdkVer = "2.24.0"
    implementation("com.oracle.oci.sdk:oci-java-sdk-core:$ociSdkVer")
    implementation("com.oracle.oci.sdk:oci-java-sdk-identity:$ociSdkVer")
    implementation("com.oracle.oci.sdk:oci-java-sdk-objectstorage:$ociSdkVer")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}