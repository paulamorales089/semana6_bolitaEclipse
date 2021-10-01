import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;

import com.google.gson.Gson;

import model.enviandoDatitos;
import processing.core.PApplet;
	// paso 0
public class principal extends PApplet{

	public static void main(String[] args) {	
		PApplet.main("principal");
	}
	//coordenadas bolita
	private int x ,y;
	//color bolita
	int r, g, b;
	
	 enviandoDatitos sendDatos;
	 //Gson gson;
	
	BufferedReader bfr;
    BufferedWriter bfw;
    
	@Override
	public void settings() {
		
		size(500,500);
	}
	
	@Override
	public void setup() {
		x = 250;
        y = 250;

        new Thread(() -> {

            try {
                System.out.println("Iniciando servidor");
                ServerSocket ss = new ServerSocket(9000);
                Socket conexion = ss.accept(); // Detiene el flujo hastas qeu haya conexion
                System.out.println("Se conecto con el cliente");

                InputStream is = (InputStream) conexion.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                bfr = new BufferedReader(isr);

                OutputStream os = (OutputStream) conexion.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                bfw = new BufferedWriter(osw);

                mensajeRecibir();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        ).start();

		}
	
	

	@Override
	public void draw() {
		background(255);
		//System.out.println(mouseX + ","+ mouseY);
		
		background(255);
		textAlign(CENTER);
		textSize(15);
		text("Soy tu bolita",250,30);
		fill (r,g,b);
		ellipse(x, y, 50,50); 
		
		
		}
	private void mensajeRecibir() {
		new Thread (
				()-> {
					
					try {

	                    String mensaje = bfr.readLine();
	                    System.out.println("mensaje recibido: " + mensaje);
	                    Gson gson =  new Gson();
	                    sendDatos = gson.fromJson(mensaje, enviandoDatitos.class);
	                    movimientoSexy();


	                } catch (IOException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
				}
	
				).start(); 
	}
		
	
	

private void movimientoSexy() {
	switch (sendDatos.getSeñalesMoviento()) {
	
	case "arriba comadre":
		y -= sendDatos.getMovimientoPixel();
		
		break;
		
	case "abajo papito":
		y += sendDatos.getMovimientoPixel();
		
		break;
		
	case "derecha mi rey":
		x += sendDatos.getMovimientoPixel();
	
		break;
		
	case "izquierda macarena":
		x -= sendDatos.getMovimientoPixel();
		break;
		
	case "coloreate nene":
		r = sendDatos.getR();
		g = sendDatos.getG();
		b = sendDatos.getB();
		break;
	
	}
	
}
}
