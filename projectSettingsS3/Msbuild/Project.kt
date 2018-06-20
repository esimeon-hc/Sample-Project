package Msbuild

import Msbuild.buildTypes.*
import Msbuild.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Msbuild")
    name = "msbuild"

    vcsRoot(Msbuild_HttpsGithubComBurnashevaMstestDotnet2gitRefsHeadsMaster)
    vcsRoot(Msbuild_HttpsGithubComBurnashevaCoreExeGitRefsHeadsMaster)

    buildType(Msbuild_MsbuildPropertiesWithSpecialSymbolsDetailedLogging)
    buildType(Msbuild_DoNotFailBuildWithExitCode1)
    buildType(Msbuild_MsbuildMstestDotnet20dotCover)
    buildType(Msbuild_MsbuildPropertiesWithSpecialSymbols)
    buildType(Msbuild_WrongPathToProjectFile)
    buildType(Msbuild_FilesFromOutside)

    subProject(Msbuild_MSTest.Project)
    subProject(Msbuild_XUnit.Project)
    subProject(Msbuild_NUnit.Project)
})
