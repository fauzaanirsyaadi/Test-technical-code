import java.util.Scanner;
import javax.ws.rs.client.CLient;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.CLientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukan angka : ");

        int angka = scanner.nextInt();
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:80000")
                .path("/generateSegitiga")
                .queryParam("angka", angka);
        Response response = target.request(MediaType.TEXT_PLAIN).get();
        String segitiga = response.readEntity(String.class);
        System.out.println(segitiga);

        target = client.target("http://localhost:80000")
                .path("/generateGanjil")
                .queryParam("angka", angka);
        response = target.request(MediaType.TEXT_PLAIN).get();
        String ganjil = response.readEntity(String.class);
        System.out.println(ganjil);

        target = client.target("http://localhost:80000")
                .path("/generatePrima")
                .queryParam("angka", angka);
        response = target.request(MediaType.TEXT_PLAIN).get();
        String prima = response.readEntity(String.class);
        System.out.println(prima);

    }

    @GetMapping(name = "/generateSegitiga")
    public String generateSegitiga(@RequestParam int angka){
        if (angka <= 0 ){
            return " angka harus positif";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < angka.length(); i++ ){
            for (int j = o; j < angka.length(); j++){
                if (j <= i){
                    sb.append(angka.charAt(j));
                }else {
                    sb.append("0");
                }
            }
        }
        return sb.toString();
    }

    @GetMapping(name = "/generateGanjil")
    public String generateGanjil(@RequestParam int angka){
        if (angka <= 0 ){
            return " angka harus positif";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1 ; i <= angka *2; i += 2){
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    @GetMapping(name = "/generatePrima")
    public String generatePrima(@RequestParam int angka){
        if (angka <= 0 ){
            return " angka harus positif";
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 2; count < angka; i++){
            if (isPRima(i)){
                sb.append(i).append(" ");
                count++;
            }
        }
        return sb.toString();

    }

    private boolean isPRima(int angka){
        if (angka < 2){
            return false;
        }

        for (int i = 2; i <- Math.sqrt(angka); i++ ){
            if (angka % i == 0 ){
                return false;
            }
        }


        return true;
    }

}
