package com.miku.ray.handler

import com.miku.ray.AppConfig
import com.miku.ray.dto.entities.ProfileItem
import com.miku.ray.util.LogUtil

object CertificateFingerprintManager {
    // Old-core shim (Lib v34, Xray-core v26.1.23): Libv2ray.fetchTlsCertSha256
    // and fetchQuicCertSha256 do not exist in this lib version (added in
    // v26.6.14), so automatic cert-fingerprint fill is unavailable. The
    // server editors still accept a manually entered fingerprint, and callers
    // already handle a null return as "could not fetch".
    fun fetchForManualFill(profile: ProfileItem): String? {
        LogUtil.d(AppConfig.TAG, "Fetch cert SHA-256 unavailable on old core (Lib v34)")
        return null
    }
}
