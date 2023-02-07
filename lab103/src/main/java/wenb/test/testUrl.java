package wenb.test;

public class testUrl {

	public static void main(String[] args) {
		
		String uri = "/front/board1/list.do";
		uri = uri.substring(0, uri.lastIndexOf("."));
		String[] uris = uri.split("/");
		for(int i=0; i<uris.length; i++) {
			System.out.println(i + " : " + uris[i] + " ");
		}
	}

}
