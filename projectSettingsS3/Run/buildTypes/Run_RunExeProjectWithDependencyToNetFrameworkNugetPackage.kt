package Run.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRun
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object Run_RunExeProjectWithDependencyToNetFrameworkNugetPackage : BuildType({
    name = "run exe project with dependency to .net framework nuget package"

    vcs {
        root(Run.vcsRoots.Run_HttpsGithubComBurnashevaCoreExeGitRefsHeadsMaster)
    }

    steps {
        dotnetRun {
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }

    triggers {
        vcs {
        }
    }
})
