package _Self

import _Self.buildTypes.*
import _Self.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({

    vcsRoot(HttpsGithubComBurnashevaASPNETCoreAngularSignalRTypescriptGitRefsHeadsMas)
    vcsRoot(HttpsGithubComBurnashevaNunitCore2gitRefsHeadsMaster)
    vcsRoot(HttpsGithubComBurnashevaMstestCoreAdapterGit)
    vcsRoot(HttpsGithubComBurnashevaMstestDotnet2gitRefsHeadsMaster)
    vcsRoot(HttpsGithubComBurnashevaNunitCoreTestsRefsHeadsMaster)

    buildType(RunBothNunitMstestDotnet20detailedLogging)
    buildType(TestFields)
    buildType(RunVstestFomNetCli)
    buildType(CustomCommandExampleMigrate)
    buildType(RunBothNunitMstestDotnet20diagnosticLogging)
    buildType(TestStepAutodiscovery)
    buildType(RunBothNunitMstestDotnet20)
    buildType(RunTestAfterNpmInstall)
    buildType(SimpleBuildAndTestProject)
    buildType(CustomCommandExampleHelp)

    params {
        password("pwd", "zxx4469c7c25073dd9f")
    }

    subProject(Pack.Project)
    subProject(Run.Project)
    subProject(Test.Project)
    subProject(DotCover.Project)
    subProject(Msbuild.Project)
    subProject(NugetPush.Project)
    subProject(Clean.Project)
    subProject(Vstest.Project)
    subProject(Build.Project)
    subProject(Publish.Project)
})
