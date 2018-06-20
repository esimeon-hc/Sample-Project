package Run.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

object Run_HttpsGithubComBurnashevaCoreExeGitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/burnasheva/core_exe.git#refs/heads/master"
    url = "https://github.com/burnasheva/core_exe.git"
})
