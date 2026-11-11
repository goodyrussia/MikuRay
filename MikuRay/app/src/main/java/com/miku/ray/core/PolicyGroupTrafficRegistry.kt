package com.miku.ray.core

object PolicyGroupTrafficRegistry {
    private val tagToGuid = mutableMapOf<String, String>()

    @Synchronized
    fun clear() {
        tagToGuid.clear()
    }

    @Synchronized
    fun register(tag: String, guid: String) {
        if (tag.isBlank() || guid.isBlank()) return
        tagToGuid[tag] = guid
    }

    @Synchronized
    fun guidForTag(tag: String): String? = tagToGuid[tag]

    // Snapshot of registered member tags, for the old-core traffic-stats shim
    // in CoreServiceManager (Lib v34 has no QueryAllOutboundTrafficStats).
    @Synchronized
    fun tags(): Set<String> = tagToGuid.keys.toSet()
}
