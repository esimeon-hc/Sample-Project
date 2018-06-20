package Build.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild

object Build_FilesFromOutside : BuildType({
    name = "files from outside"

    steps {
        dotnetBuild {
            projects = "/Users/nburnasheva/temp/dot_net_core/**/*.csproj"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }
})
