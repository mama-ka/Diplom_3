import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.projectFeatures.githubAppConnection
import jetbrains.buildServer.configs.kotlin.triggers.vcs

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2023.05"

project {

    buildType(Build)

    features {
        githubAppConnection {
            id = "PROJECT_EXT_40"
            displayName = "GitHub App"
            appId = "381158"
            clientId = "Iv1.ea65562d1f2e8009"
            clientSecret = "zxx0693058d516b6b90f6f5f985098b0f4d0022d5cc34f63658b66e6f14de486612f1f7b1b98e152f6a775d03cbe80d301b"
            privateKey = "zxx0ead0f89b53aab8c18829126191f80d8f851ffcd3e40676b5c7ef97fc4e4128b024ef5cf5973ed28bb3dcb2414a832ec6a5bd64b2370cba432c1ec13ce13a5839735c3ce6e1ce3291adcc17708826dd9203903b52853e10c2c47a22dfe51c2acdec441dd9aa82ef21178ed483710bf681fc81589e18408991edbaa26dda65a264fbe447bb9ade79d5cd1f89f81fe51b663c2b12d44533251976ca49eb733ffc719f37c31f6dabb575cc8b8a9c42005fdd046dd86d4a7aef3a31bfe216132cacce9aebda700a03767b8daf3990c2f1181b4d32424231ae09e63d13e952f7a48630777c725d46c689fa2c10fd2d530257bfbe2f0b07880446b47e0e3f4b05d7708d2fbb87fb44db61e518ce7576b73fdbf529a56e593552e67d0741de4b6fff1e4974aa0e4ed34a6f216c6aeda1d60b263781bd73b57c15b2845175f3e15a1712ae455bef7207aa19bc347084883e1e95038c8868fbcee2a47a20c9f93e8ff515d87676dd76b143a4aa2912dd7d78e2341b6e64b9703cefdb33915892ecf4443df10511abf065679a234f1f2ce85c6b3e6218c0b70381c59e80e15b79b9b33a650b1b1dd71a816151dad625e2bb2f39645947e347e5b5a4516d7282c2fd4aa18d4e7c7b023958c782314fb00380afccf2abb37034b63ffe53e78576202973c60397c555e15c2a7c9a5c60046229bb69722ce5f070e1e0eece29f5f27ca990c3afb8adb32e16b156ec573bdcf013ec42399d741bdb7ea0c4bab83490552a63788b274b53e04d276dacfb47fea73344b5f90473c2c22d5f2dff9a81e3fd9e84fe2f0edabc443a6635665eee6106461cb5b68507e5b1e9046a3dc02e802c1f9540883f28267524fc5107809e8f6f3488a2eb18b413f024a01a9bbc4c2d1c12de2d764bc959b8abefea4ebd7baa1475b21b0273fa88a3fd2dc1159c26a45fdf959769d31556809ec3b8e99c72fec4ed9ab40a51f505eecce875e3b66e5c0bcbd5cc58ffa42376c13043b7cf9d4836ec5c401edda0afe911c0ad24640f20d77812be33eb32790897006d3225d7a51945f47127f6f4f3fe71f0cb6feaf75d967f6677c8ab0d7b6378c05151a4cd1bade70570495ca6f7d2dcbf6bfe5c6d1a691ded3625d10c21d600fcc78339e8de6185251ea597955d6bb2a15c7d4e28d342c45deb2bdb951f3865a9900200546787c9fb771fc4b1174bc8b3719c6989b4fdf8edaa64263938778f876f0fb41e07aed1177d530cd51db5e3d8e4d38ed2ae033df225e3f0d17b8972076f94dbb2dc5bb62b29ba1c5fad94db34566f75f1c53b5b26ce2133eba77c9191c997dd4cc58cff5e0bf949bf07f8112f5a6894995a9dc9367c5b05f90ab9fdbfb4cfeb6b6e9c2d1592d50a5ed0629293716119a0811cd49c91917148c383a578a7b13df2bdc09a2a09dda62b1835e74126434e74de6ed30d8d28b82c8bf887652e383b297ffa18ddd3683e9b2cec66118611de6e39cc9acdcce6cf1a4891e92a0c38c76e8d0d78e151d9068e3097f1a85de17810ca116f5884cc6c597dd66d5ba7038a258c1826f43f4f06f92f70a8c128501225e46de3781a704e44ad291b2af981c3eb2bed461536c7c31aeea7400a46b3ecd7e5e24475eb285f50d7ad4c355bebacdca51b5160981aa033b94842e06dd899442c7ee232829fea7afe1c279c0240f4059c90009ec628bc283eee51b8461c297630709331fc9b15645a1b6b493d8ef78aa4730ac9fed13cc5d310dfe5b510cc1fdcbd637f4ba3bebe14ddb3d45fd67e8a259b6efa7487b5b223046ddb57913f3069b631377f27bce1b8a8a0ea6047fb4e655b526eef3f98822ac8b7f14e389afd29a793862b4a66f09864312e9effc2722bd107c37e65f0862075c7417d2d7fdae7f937c1e9c8b0268ee792eacff026d82d5a9dbe2d8d72369ac361aace531eb5d4c9436697092c5f9d545dd20418ccb8d7b3cca0909c9efd1f6c47d95d12f746aa4afabc63990c571c273598197202aeddc499afdfd0177a66b17cf437893ecd9acde79fc70b122211fc94f8cf8704c098223ac9af0f1c993fc2f34c12355ecd33d42de90eaa5740dcc502798802469e6908c993b270c4be5325d8988fe166be77609c7014e62a4410a7958cbaccca5ad52ab6b40c4df0d336ed8839c2292a1627468eac5bae6a5ac7c9382d9492ddf859472cd6592dc4e189923e5e0da52339cb6a01ca3fc1f919b5b34588fd0e8903fb3a7887679dc60353fbecf78f332156c04a13be4a1dd1526e3230181787ff0a5f834527709816fbacc6637243083235286f816a6093da81be2592c5f997b7c46c73148d35b13e6aa75a3dece9e38bff65766c9a8593dabe6eefdb3407f4383fd7886d964c9f9"
            ownerUrl = "https://github.com/dumamoiseev"
        }
    }
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})
