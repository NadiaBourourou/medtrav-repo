package gui.questions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import entities.User;

    public class VideoExample {
private User userConnected;
        public  EmbeddedMediaPlayerComponent mediaPlayerComponent;

        public static void main(final String[] args) {
         NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\Program Files\\VideoLAN\\VLC");
        
         Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new VideoExample(args);
                }
            });
        }

        public VideoExample(String[] args) {
            JFrame frame = new JFrame("Meaning of medical travel ");

            mediaPlayerComponent = new EmbeddedMediaPlayerComponent();

            frame.setContentPane(mediaPlayerComponent);

            frame.setLocation(100, 100);
            frame.setSize(500, 500);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            URL url = getClass().getResource("video.avi");
            mediaPlayerComponent.getMediaPlayer().playMedia("\\target\\classes\\gui\\questions\\video.avi");
           
           Timer every50millis = new Timer(50, new ActionListener() {
                private int count=0;
                @Override
                public void actionPerformed(ActionEvent e) {
                    count++;
                   
                    if (count==230) {
                       frame.dispose();
                       ListQuestions frame = new ListQuestions();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
                    }
                }
            });
            every50millis.start();
            
        
        //   frame.dispose();
            
           
           
        }
        
        
        public VideoExample(User userConnected) {
        	System.out.println("VIDEO EXEMPLE");
    		System.out.println("user co id="+userConnected.getUserId());
    		System.out.println("user co name="+userConnected.getFirstName()+userConnected.getLastName());		
    		
        	JFrame frame = new JFrame("Meaning of medical travel ");

            mediaPlayerComponent = new EmbeddedMediaPlayerComponent();

            frame.setContentPane(mediaPlayerComponent);

            frame.setLocation(100, 100);
            frame.setSize(500, 500);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            URL url = getClass().getResource("video.avi");
            mediaPlayerComponent.getMediaPlayer().playMedia("\\target\\classes\\gui\\questions\\video.avi");
           
           Timer every50millis = new Timer(50, new ActionListener() {
                private int count=0;
                @Override
                public void actionPerformed(ActionEvent e) {
                    count++;
                   
                    if (count==230) {
                       frame.dispose();
                       ListQuestions frame = new ListQuestions(userConnected);
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
                    }
                }
            });
            every50millis.start();
            
        
        //   frame.dispose();
            
           
           
        }
        
    }