package DotCover

import DotCover.buildTypes.*
import DotCover.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("DotCover")
    name = "dotCover"

    vcsRoot(DotCover_HttpsGithubComBurnashevaXunitCoreAdapterRefsHeadsMaster)
    vcsRoot(DotCover_HttpsGithubComBurnashevaMstestDotnet2gitRefsHeadsMaster)
    vcsRoot(DotCover_HttpsGithubComBurnashevaNunitCore2gitRefsHeadsMaster)
    vcsRoot(DotCover_HttpsGithubComBurnashevaNunitCoreTestsGitRefsHeadsMaster)

    buildType(DotCover_TestDotCoverProjectFile)
    buildType(DotCover_NunitMstestDotnet20dotCoverDefault)
    buildType(DotCover_MsbuildDotCoverDefault)
    buildType(DotCover_NunitDotnet20dotCover)
    buildType(VstestDotCover)
    buildType(DotCover_MsbuildDotCover20173)
    buildType(DotCover_NunitTestDotCover)
    buildType(DotCover_SeveralAssembliesForCoverageTestDotCover)
    buildType(DotCover_XunitTestDotCover)
    buildType(DotCover_NunitMstestDotnet20withoutCoverage)
    buildType(DotCover_TestDotCoverSolutionFile)
    buildType(DotCover_MsbuildMstestDotnet20dotCover)
    buildType(DotCover_NunitTestDotCoverNoTestsToRun)
    buildType(DotCover_NunitMstestDotnet20dotCoverPreviouslyBundledVersion)
    buildType(DotCover_NunitMstestDotnet20dotCover20173)
    buildType(DotCover_VstestDotCoverNotAssembliesToAnalyze)
    buildType(DotCover_MstestDotnet20dotCover)
})
