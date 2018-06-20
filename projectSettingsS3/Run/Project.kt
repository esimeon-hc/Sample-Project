package Run

import Run.buildTypes.*
import Run.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Run")
    name = "run"

    vcsRoot(Run_HttpsGithubComBurnashevaCoreExeGitRefsHeadsMaster)

    buildType(Run_DoNotFailBuildWithExitCode1)
    buildType(Run_OutsideOfWorkingDirectory)
    buildType(Run_RunWithWildcards)
    buildType(Run_RunExeProjectWithDependencyToNetFrameworkNugetPackage)
    buildType(Run_RunWithRuntimeField)
})
