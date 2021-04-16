package com.example.practicasemana9;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {


   // private Button accion;
    DatagramSocket socket;
    private ImageView burguer,jugos,wrap,perro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       // accion = findViewById(R.id.accion);
        burguer = findViewById(R.id.burguer);
        jugos = findViewById(R.id.jugo);
        wrap = findViewById(R.id.wrap);
        perro = findViewById(R.id.perro);

        new Thread(

                ()->{

                    try {
                        socket = new DatagramSocket(5000);
                        Log.e("-->","Esperando");
                        //Recepción
                        while (true) {
                            byte[] buff = new byte [256];
                            DatagramPacket packet = new DatagramPacket(buff, buff.length);

                           // System.out.println("Waiting");
                            socket.receive(packet);
                            String recibido = new String (packet.getData()).trim();
                          //  System.out.println(recibido);
                            Log.e("-->",recibido);
                            runOnUiThread(
                                    () -> {

                                        Toast.makeText(this,recibido,Toast.LENGTH_LONG).show();
                                    }

                            );
                        }
                    } catch (SocketException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }).start();

        burguer.setOnClickListener(

                v -> {
                    new Thread(
                            () -> {
                                try {
                                    // DatagramSocket socket = new DatagramSocket(5000);

                                    String mensaje = "Hamburguesa";
                                    DatagramPacket packet = new DatagramPacket(
                                            mensaje.getBytes(),
                                            mensaje.getBytes().length,
                                            InetAddress.getByName("10.0.2.2"),
                                            6000
                                    );
                                    socket.send(packet);

                                } catch (SocketException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (UnknownHostException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                    ).start();
                }
        );

        wrap.setOnClickListener(

                v -> {
                    new Thread(
                            () -> {
                                try {
                                    // DatagramSocket socket = new DatagramSocket(5000);

                                    String mensaje = "Wrap";
                                    DatagramPacket packet = new DatagramPacket(
                                            mensaje.getBytes(),
                                            mensaje.getBytes().length,
                                            InetAddress.getByName("10.0.2.2"),
                                            6000
                                    );
                                    socket.send(packet);

                                } catch (SocketException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (UnknownHostException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                    ).start();
                }
        );

        jugos.setOnClickListener(

                v -> {
                    new Thread(
                            () -> {
                                try {
                                    // DatagramSocket socket = new DatagramSocket(5000);

                                    String mensaje = "Jugos";
                                    DatagramPacket packet = new DatagramPacket(
                                            mensaje.getBytes(),
                                            mensaje.getBytes().length,
                                            InetAddress.getByName("10.0.2.2"),
                                            6000
                                    );
                                    socket.send(packet);

                                } catch (SocketException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (UnknownHostException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                    ).start();
                }
        );

        perro.setOnClickListener(

                v -> {
                    new Thread(
                            () -> {
                                try {
                                    // DatagramSocket socket = new DatagramSocket(5000);

                                    String mensaje = "Perro";
                                    DatagramPacket packet = new DatagramPacket(
                                            mensaje.getBytes(),
                                            mensaje.getBytes().length,
                                            InetAddress.getByName("10.0.2.2"),
                                            6000
                                    );
                                    socket.send(packet);

                                } catch (SocketException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (UnknownHostException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                    ).start();
                }
        );




    }
}