package Clean

import Clean.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Clean")
    name = "clean"

    buildType(Clean_FilesFromOutside)
    buildType(Clean_DoNotFailBuildWithExitCode1)
    buildType(Clean_Wild)
})
