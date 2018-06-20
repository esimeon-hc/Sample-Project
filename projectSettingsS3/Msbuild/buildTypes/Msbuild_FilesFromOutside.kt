package Msbuild.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetMsBuild

object Msbuild_FilesFromOutside : BuildType({
    name = "files from outside"

    steps {
        dotnetMsBuild {
            projects = "/Users/nburnasheva/temp/dot_net_core/**/*.csproj"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }
})
