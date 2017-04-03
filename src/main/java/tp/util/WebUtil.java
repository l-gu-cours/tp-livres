package tp.util;

import javax.servlet.http.HttpServletResponse;

public class WebUtil {

	/**
	 * Permet d'éviter les effets de cache du navigateur <br>
	 * 
	 * Utilisation dans les servlets ( à placer avant première instruction de traitement de la réponse ) : <br>
	 *   WebUtil.noCache(response);<br>
	 * 
	 * @param response
	 */
	public static void noCache( final HttpServletResponse response )
	{
        response.setHeader ("Pragma", "no-cache"); //HTTP 1.0
        
        response.setHeader ("Cache-Control", "no-cache"); //HTTP 1.1
        // response.setHeader("Cache-Control","no-store"); 
        // "no-store" is used sometimes, but "no-cache" is the more polite keyword
        
        response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
	}
}
