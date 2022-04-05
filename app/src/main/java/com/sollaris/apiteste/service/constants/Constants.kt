package com.sollaris.apiteste.service.constants

class Constants private constructor() {

    // SharedPreferences
    object SHARED {
        const val ACESS_TOKEN = "acesstoken"
        const val REFRESH_TOKEN = "refreshtoken"
        const val TIME_TOKEN = "timetoken"
    }

    object HEADER {
        const val TOKEN_KEY = "token"
        const val PERSON_KEY = "personkey"
    }

    object HTTP {
        const val SUCCESS = 200
    }

    object BUNDLE {
        const val TASKID = "taskid"
        const val TASKFILTER = "taskfilter"
    }

    object FILTER {
        const val ALL = 0
        const val NEXT = 1
        const val EXPIRED = 2
    }

}