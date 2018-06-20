package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object RunTestAfterNpmInstall : BuildType({
    name = "run test after npm install"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaASPNETCoreAngularSignalRTypescriptGitRefsHeadsMas)
    }

    steps {
        step {
            type = "jonnyzzz.npm"
            param("teamcity.build.workingDir", "src/AspNetCoreAngular2")
            param("npm_commands", "install")
        }
        dotnetRestore {
            projects = "**/*.csproj"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetBuild {
            projects = "**/*.csproj"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetTest {
            projects = "AspNetCoreAngular2.sln"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }

    triggers {
        vcs {
        }
    }
})
