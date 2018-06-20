package Pack

import Pack.buildTypes.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Pack")
    name = "pack"

    buildType(Pack_BuildWithRuntime)
    buildType(Pack_DoNotFailBuildWithExitCode1)
    buildType(Pack_OutsideOfCheckoutDirectory)
})
