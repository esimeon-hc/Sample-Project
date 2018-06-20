package Publish.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

object Publish_HttpsGithubComBurnashevaCoreExeGit : GitVcsRoot({
    name = "https://github.com/burnasheva/core_exe.git"
    url = "https://github.com/burnasheva/core_exe.git"
})
