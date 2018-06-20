package Build

import Build.buildTypes.*
import Build.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Build")
    name = "build"

    vcsRoot(Build_HttpsGithubComBurnashevaMstestDotnet2gitRefsHeadsMaster)
    vcsRoot(Build_HttpsGithubComBurnashevaXunitCoreAdapter)

    buildType(Build_RunTestsWithTVstestCommand)
    buildType(Build_DoNotFailBuildWithExitCode1)
    buildType(Build_FilesFromOutside)
    buildType(Build_Wildcards)
    buildType(Build_AuthenticationToTeamCityNuGetFeed)
    buildType(Build_RunTestsWithTVstest)

    subProject(Build_XUnit.Project)
    subProject(Build_NUnit.Project)
    subProject(Build_MSTest.Project)
})
