package Msbuild.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

object Msbuild_HttpsGithubComBurnashevaMstestDotnet2gitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/burnasheva/mstest_dotnet2.git#refs/heads/master"
    url = "https://github.com/burnasheva/mstest_dotnet2.git"
})
