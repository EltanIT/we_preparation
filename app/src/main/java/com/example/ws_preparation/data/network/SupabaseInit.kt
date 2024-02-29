package com.example.ws_preparation.data.network

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.realtime.Realtime

object SupabaseInit {

    val client = createSupabaseClient(
        "https://fxaeozzwjtrpdjkpbzvw.supabase.co",
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZ4YWVvenp3anRycGRqa3BienZ3Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MDkxOTExOTMsImV4cCI6MjAyNDc2NzE5M30.JGssq1fxmcoHYOoIWCtH52sOGbzEeb39g5Ak8vjN0vo"
    ){
        install(Postgrest)
        install(Realtime)
        install(Auth)
    }
}