package org.abimon.eternalJukebox.objects

import org.abimon.visi.lang.asOptional
import java.io.File
import java.util.*

data class JukeboxConfig(
        var ip: String = "http://\$ip:\$port", //The IP to listen on. Used for OAuth2 callback and song hosting.
        val ssl: Optional<SSLCertPair> = Optional.empty(), //Whether to use SSL/HTTPS

        val fileManager: Optional<Pair<String, String>> = Pair("/files/*", "files").asOptional(), //The file manager locations to use. First is the endpoint, second is the directory.

        val retroIndexEndpoint: Optional<String> = "/retro_index.html".asOptional(),
        val faqEndpoint: Optional<String> = "/faq.html".asOptional(),

        val jukeboxIndexEndpoint: Optional<String> = "/jukebox_index.html".asOptional(),
        val jukeboxGoEndpoint: Optional<String> = "/jukebox_go.html".asOptional(),
        val jukeboxSearchEndpoint: Optional<String> = "/jukebox_search.html".asOptional(),

        val canonizerIndexEndpoint: Optional<String> = "/canonizer_index.html".asOptional(),
        val canonizerGoEndpoint: Optional<String> = "/canonizer_go.html".asOptional(),
        val canonizerSearchEndpoint: Optional<String> = "/canonizer_search.html".asOptional(),

        val expandRedirectEndpoint: Optional<String> = "/expand/:id".asOptional(), //Must feature :id in the endpoint

        val robotsTxt: String = "User-agent: * \nDisallow:",
        val faviconPath: Optional<String> = "files${File.separator}favicon.png".asOptional(),
        val appleTouchIconPath: Optional<String> = "files${File.separator}apple-touch-icon.png".asOptional(),

        val loginEndpoint: Optional<String> = "/login.html".asOptional(),
        val logAllPaths: Boolean = false,
        val logMissingPaths: Boolean = false,
        val port: Int = 11037,

        val storeSongInformation: Boolean = true,
        val storeSongs: Boolean = true,
        val storeAudio: Boolean = true,

        val redirects: Map<String, String> = hashMapOf(Pair("index.html", "jukebox_index.html"), Pair("/", "jukebox_index.html")),

        var spotifyBase64: Optional<String> = Optional.empty(),
        var spotifyClient: Optional<String> = Optional.empty(),
        var spotifySecret: Optional<String> = Optional.empty(),

        val cors: Boolean = true,

        val googleClient: Optional<String> = Optional.empty(),
        val googleSecret: Optional<String> = Optional.empty(),
        val eternityUserKey: String = "Eternity-User",

        val httpOnlyCookies: Boolean = true,
        val secureCookies: Boolean = false,

        val csrf: Boolean = true,
        val csrfSecret: String = UUID.randomUUID().toString(),

        val epoch: Long = 1489148833,

        val mysqlUsername: Optional<String> = Optional.empty(),
        val mysqlPassword: Optional<String> = Optional.empty(),
        val mysqlDatabase: Optional<String> = Optional.empty(),

        val httpsOverride: Boolean = false,

        val uploads: Boolean = false,

        val firebaseApp: Optional<String> = Optional.empty(),
        val firebaseDevice: Optional<String> = Optional.empty(),

        val storageSize: Long = 10L * 1000 * 1000 * 1000, //How much storage space should be devoted to Spotify caches, YouTube caches, and uploaded files.
        val storageBuffer: Long = storageSize / 10 * 9,
        val storageEmergency: Long = storageSize / 10 * 11,

        val cacheFiles: Boolean = true,
        val enforceHttps: Boolean = ssl.isPresent,
        val format: String = "mp3",

        val vertxBlockingTime: Long = 5 * 60L * 1000 * 1000000,

        val shortIDLength: Int = 4 //No greater than 16
)

data class SSLCertPair(val key: String, val cert: String) {
    constructor(keys: Array<String>): this(keys[0], keys[1])
}