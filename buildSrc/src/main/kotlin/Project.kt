import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.dependencies

fun Project.withImplementation(vararg libs: String) {
    dependencies {
        libs.forEach {
            implementation(it)
        }
    }
}

private fun DependencyHandler.implementation(dependency: Any) {
    add("implementation", dependency)
}
