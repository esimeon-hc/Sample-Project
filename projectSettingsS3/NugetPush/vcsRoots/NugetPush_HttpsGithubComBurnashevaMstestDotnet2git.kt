package NugetPush.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

object NugetPush_HttpsGithubComBurnashevaMstestDotnet2git : GitVcsRoot({
    name = "https://github.com/burnasheva/mstest_dotnet2.git"
    url = "https://github.com/burnasheva/mstest_dotnet2.git"
})
