import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class team extends JFrame{
	boolean [][][][] check = new boolean[7][65][5][6];
	String sr = new String();
	private int btninfo, datenum;
	private String zone = new String();
	
	private String [] busan_numstr = new String[24]; //항공기 번호 저장
	private String [] busan_go = new String[24]; // 출발시간 저장
	private String [] busan_end = new String[24]; //도착시간 저장
	private String [] busan_fly = new String[24]; //비행시간 저장
	private String [] busan_seat = new String[24]; //좌석정보 저장
	private String [] busan_money = new String[24]; // 가격정보 저장

	private String [] jin_numstr = new String[24]; //항공기 번호 저장  여기는 진에어
	private String [] jin_go = new String[24]; // 출발시간 저장
	private String [] jin_end = new String[24]; //도착시간 저장
	private String [] jin_fly = new String[24]; //비행시간 저장
	private String [] jin_seat = new String[24]; //좌석정보 저장
	private String [] jin_money = new String[24]; // 가격정보 저장
	
	private String [] kor_numstr = new String[24]; //항공기 번호 저장    여기는 대한항공
	private String [] kor_go = new String[24]; // 출발시간 저장 
	private String [] kor_end = new String[24]; //도착시간 저장
	private String [] kor_fly = new String[24]; //비행시간 저장
	private String [] kor_seat = new String[24]; //좌석정보 저장
	private String [] kor_money = new String[24]; // 가격정보 저장
	
	private String [] busanjeju_numstr = new String[24]; //항공기 번호 저장    여기는 부산 -> 제주
	private String [] busanjeju_go = new String[24]; // 출발시간 저장 
	private String [] busanjeju_end = new String[24]; //도착시간 저장
	private String [] busanjeju_fly = new String[24]; //비행시간 저장
	private String [] busanjeju_seat = new String[24]; //좌석정보 저장
	private String [] busanjeju_money = new String[24]; // 가격정보 저장
	
	private String [] koreajeju_numstr = new String[24]; //항공기 번호 저장    여기는 대한 -> 제주
	private String [] koreajeju_go = new String[24]; // 출발시간 저장 
	private String [] koreajeju_end = new String[24]; //도착시간 저장
	private String [] koreajeju_fly = new String[24]; //비행시간 저장
	private String [] koreajeju_seat = new String[24]; //좌석정보 저장
	private String [] koreajeju_money = new String[24]; // 가격정보 저장
	
	private String [] jeju_numstr = new String[24]; //항공기 번호 저장    여기는 제주항공
	private String [] jeju_go = new String[24]; // 출발시간 저장 
	private String [] jeju_end = new String[24]; //도착시간 저장
	private String [] jeju_fly = new String[24]; //비행시간 저장
	private String [] jeju_seat = new String[24]; //좌석정보 저장
	private String [] jeju_money = new String[24]; // 가격정보 저장
	
	public team() {
		setTitle("김해, 김포공항 항공권 예매");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(null);
		
		JButton stbtn = new JButton("시작");
		stbtn.setFont(new Font("맑은굴림", Font.PLAIN, 40));
		stbtn.setLocation(625, 600);
		stbtn.setSize(150,50);
		c.add(stbtn);
		
		JButton box = new JButton();
		box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}
		});
		
		JLabel stla = new JLabel("항공편 예매");
		stla.setForeground(Color.BLACK);
		stla.setFont(new Font("굴림", Font.PLAIN, 70));
		stla.setLocation(500, 100);
		stla.setSize(400, 200);
		c.add(stla);
		
		box.setEnabled(false); 
        box.setBackground(new Color(255, 255, 255));
        box.setBounds(500, 150, 370, 90); 
        c.add(box);
        
		ImageIcon stima = new ImageIcon("images/1.jpg");
		JLabel stimala = new JLabel(stima);
		stimala.setLocation(0,0);
		stimala.setSize(1400, 1000);
		c.add(stimala);
		
		stbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		stbtn.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				c.removeAll();
				c.revalidate();
				c.repaint();
				c.add(new LoginPages());
			}
		});
		setSize(1400,1000);
		setVisible(true);
		setResizable(false);
	}
	
	class LoginPages extends JPanel {
		Image img = null;
		public LoginPages() {
			Container c= getContentPane();
			c.setLayout(null);
			
			JLabel imglabel = new JLabel (new ImageIcon("images/1.jpg"));
			imglabel.setBounds(0, 0, 1400, 1000);
			
			JLabel la = new JLabel("로그인");
			la.setForeground(Color.BLACK);
			la.setFont(new Font("굴림", Font.PLAIN, 70));
			la.setLocation(590, 160);
			la.setSize(210, 80);
			la.setOpaque(true);
			c.add(la);
			
			JLabel id = new JLabel("아이디 : ");
			id.setBounds(520, 355, 50, 20);
			id.setOpaque(true);
			c.add(id);//110 차이
			TextField tfid = new TextField();
			tfid.setBounds(600, 350, 200, 30);
			c.add(tfid);//230
			JButton login = new JButton("로그인");
			login.setBounds(830, 350, 80, 30);
			c.add(login);

			JLabel pw= new JLabel("비밀번호 : ");
			pw.setBounds(520, 395, 60, 20);
			pw.setOpaque(true);
			c.add(pw);//110차이
			TextField tfpw = new TextField();
			tfpw.setBounds(600, 390, 200, 30);
			c.add(tfpw);//230
			tfpw.setEchoChar('*'); //암호화
			JButton useradd = new JButton("회원가입");
			useradd.setBounds(830, 390, 90, 30);
			c.add(useradd);
			c.add(imglabel);
			
			login.addActionListener(new ActionListener() {  // 로그인 구현
				public void actionPerformed(ActionEvent e2) {
					try{
						String s;
						BufferedReader bos = new BufferedReader(new FileReader("회원정보.txt"));
						
						boolean login = false;
						
						if(tfid.getText() == null) {
							JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
						}
						else {
							while((s=bos.readLine())!=null) {
								String[] array = s.split("/");
								if(tfid.getText().equals(array[0])&&tfpw.getText().equals(array[1])) {
									login = true;
									break;
								}
								else  {
									login = false;
								}
							}
						}
						if(login) {
							JOptionPane.showMessageDialog(null, "Login Complete");
							c.removeAll();
							c.revalidate();
							c.repaint();
							new world();
						} else {
							JOptionPane.showMessageDialog(null, "아이디 혹은 패스워드가 잘못되었습니다.");
						}
						bos.close();
					}catch (IOException E10){E10.printStackTrace();}
				}
			});
			
			useradd.addActionListener(new ActionListener() {  // 회원가입(addUser로 이동)
				public void actionPerformed(ActionEvent e) {
					new addUser();
				}
			});
		}
	}
	
	class world extends JPanel {	
		public world() {
			Container c = getContentPane();
			c.setLayout(null);
			
			JLabel la = new JLabel("여행지역 선택");
			la.setLocation(20, 10);
			la.setSize(300,30);
			la.setFont(new Font("굴림", Font.PLAIN, 30));
			c.add(la);
			// 국내선 김포, 제주
			JLabel la1 = new JLabel("국내선");
			la1.setLocation(20, 50);
			la1.setSize(300,30);
			la1.setFont(new Font("굴림", Font.PLAIN, 30));
			c.add(la1);
			
			ImageIcon krim = new ImageIcon("images/korea.png");
			JLabel krimla = new JLabel(krim);
			krimla.setLocation(10, 90);
			krimla.setSize(450, 300);
			
			JButton kbox = new JButton();
			kbox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {}
			});
			
			ImageIcon kpbtim = new ImageIcon("images/seoul.png");
			JButton kpbtn = new JButton(kpbtim);
			kpbtn.setLocation(49, 116);
			kpbtn.setSize(134, 108);
			kpbtn.setToolTipText("김포 예약하기");
			kpbtn.setBorderPainted(false);
			
			ImageIcon jjbtim = new ImageIcon("images/jeju.png");
			JButton jjbtn = new JButton(jjbtim);
			jjbtn.setLocation(30, 296);
			jjbtn.setSize(143, 80);
			jjbtn.setToolTipText("제주 예약하기");
			jjbtn.setBorderPainted(false);
			
			JLabel ex = new JLabel("예매하고싶은 지역에 마우스를 클릭해세요");
			ex.setLocation(10, 400);
			ex.setSize(300,30);
			ex.setFont(new Font("굴림", Font.PLAIN, 15));
			c.add(ex);
			
			c.add(jjbtn);
			c.add(kpbtn);
			c.add(krimla);
			
			kbox.setEnabled(false); 
	        kbox.setBackground(new Color(240, 240, 240));
	        kbox.setBounds(5, 85, 460, 310); 
	        c.add(kbox);
			//김해-김포
	        kpbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			kpbtn.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					JButton btn = (JButton)e.getSource();
					zone = btn.getToolTipText();
					c.removeAll();
					c.revalidate();
					c.repaint();
					new date();
				}
			});
			//김해-제주
			jjbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jjbtn.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					JButton btn = (JButton)e.getSource();
					zone = btn.getToolTipText();
					c.removeAll();
					c.revalidate();
					c.repaint();
					new date();
				}
			});
			//국제선 중국, 일본
			JLabel ex2 = new JLabel("예매하고싶은 지역에 마우스를 클릭해세요");
			ex2.setLocation(10, 820);
			ex2.setSize(300,30);
			ex2.setFont(new Font("굴림", Font.PLAIN, 15));
			c.add(ex2);
			
			JLabel la2 = new JLabel("국제선");
			la2.setLocation(20, 460);
			la2.setSize(300,30);
			la2.setFont(new Font("굴림", Font.PLAIN, 30));
			c.add(la2);
			
			ImageIcon chim = new ImageIcon("images/china1.png");
			JLabel chimla = new JLabel(chim);
			chimla.setLocation(10, 510);
			chimla.setSize(450, 300);
			
			JButton cbox = new JButton();
			cbox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {}
			});
			
			ImageIcon chbtim = new ImageIcon("images/chinabtn.png");
			JButton cbtn = new JButton(chbtim);
			cbtn.setLocation(36, 641);
			cbtn.setSize(181, 123);
			cbtn.setBorderPainted(false);
			cbtn.setToolTipText("홍콩 예약하기");
			c.add(cbtn);
			c.add(chimla);
			
	        cbox.setEnabled(false); 
	        cbox.setBackground(new Color(240, 240, 240));
	        cbox.setBounds(5, 505, 460, 310); 
	        c.add(cbox);
			
	        cbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			cbtn.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					c.removeAll();
					c.revalidate();
					c.repaint();
				}
			});
			
			ImageIcon jpim = new ImageIcon("images/japan1.png");
			JLabel jpimla = new JLabel(jpim);
			jpimla.setLocation(475, 510);
			jpimla.setSize(450, 300);
			
			JButton jbox = new JButton();
			jbox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {}
			});
			
			ImageIcon jpbtim = new ImageIcon("images/jpbtn.png");
			JButton jbtn = new JButton(jpbtim);
			jbtn.setLocation(480, 542);
			jbtn.setSize(220, 117);
			jbtn.setBorderPainted(false);
			jbtn.setToolTipText("도쿄 예약하기");
			c.add(jbtn);
			c.add(jpimla);
			
			jbox.setEnabled(false); 
			jbox.setBackground(new Color(240, 240, 240));
			jbox.setBounds(470, 505, 460, 310); 
	        c.add(jbox);
			
	        jbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
			jbtn.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					c.removeAll();
					c.revalidate();
					c.repaint();
				}
			});
			
			ToolTipManager m = ToolTipManager.sharedInstance();
			m.setInitialDelay(0);
			m.setDismissDelay(3000);
		}
	}
	
	class date extends JPanel {
		
		public date() {
			Container c = getContentPane();
			c.setLayout(null);
			
			JButton back = new JButton(new ImageIcon("images/back.png"));
			back.setSize(80, 73);
			back.setLocation(1300, 10);
			back.setBackground(new Color(240, 240, 240));
			back.setBorderPainted(false);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					c.removeAll();
					c.revalidate();
					c.repaint();
					c.add(new world());
				}
			});
			c.add(back);
			
			JLabel title = new JLabel("날짜를 선택해주세요.");
			title.setLocation(500,20);
			title.setSize(600, 90);
			title.setFont(new Font("굴림", Font.PLAIN, 40));
			c.add(title);
			
			JLabel cal = new JLabel(new ImageIcon("images/calender.png"));
			cal.setLocation(250, 130);
			cal.setSize(900, 730);
			
			JButton [] dtbtn = new JButton[7];
			ImageIcon [] num = {new ImageIcon("images/21.png"), new ImageIcon("images/22.png"),
					new ImageIcon("images/23.png"), new ImageIcon("images/24.png"),
					new ImageIcon("images/25.png"), new ImageIcon("images/26.png"), new ImageIcon("images/27.png")};
			
			for(int i=0; i<7; i++) {
				dtbtn[i] = new JButton(num[i]);
				dtbtn[i].setToolTipText(Integer.toString(i+21));
				if(i<6) {
					dtbtn[i].setLocation(425 + (i*122), 665);
					dtbtn[i].setSize(60, 64);
					dtbtn[i].setBorderPainted(false);
					dtbtn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
				}else if(i==6) {
					dtbtn[i].setLocation(305, 771);
					dtbtn[i].setSize(60, 64);
					dtbtn[i].setBorderPainted(false);
				}
				dtbtn[i].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						JButton btn = (JButton)e.getSource();
						datenum = Integer.parseInt(btn.getToolTipText());
						c.removeAll();
						c.revalidate();
						c.repaint();
						if(zone == "김포 예약하기") {
							new Kr_AirBusan();
							new Kr_koreaair();
						} else if(zone == "제주 예약하기") {
							new Jj_AirBusan();
							new Jj_koreaair();
							new Jj_jejuair();
						}
						
					}
				});
				c.add(dtbtn[i]);
			}
			c.add(cal);
			
			ToolTipManager m = ToolTipManager.sharedInstance();
			m.setEnabled(false);
		}
	}
	
	class Kr_AirBusan extends JPanel{  //제일큰 패널이다  김포공항 예약 페이지 
		private String [] str = { "출발지 : ","도착지 : ","출발시간 : ", "도착시간 : "};
		private String [] number = new String[20];
		private String startp = "김해공항";
		private String lastp = "김포공항";
		private String [] start = new String[20];
		private String [] finish = new String[20];
		private JLabel [] la = new JLabel[4];
		private JButton [] box = new JButton[6];
		private int x=50 , y=85 , z=400 , v=120, buy1=230; //buy1은 구매하기버튼의 y좌표를 뜻함
		private JButton [] buy = new JButton[5];
		private String [] price = new String[20];
		
		private void data(ResultSet srs, String s, String f, String p, String n, String e) throws SQLException {
			int i=0;
			while(srs.next()) {
				if(s != "") {
					start[i] = new String((srs.getString("start"))); //출발시간 저장하기
					busan_go[i] = start[i];
				}
				if(f != "") {
					finish[i] = new String((srs.getString("finish"))); //도착시간 저장하기
					busan_end[i] = finish[i];
				}
				if(p != "") {
					price[i] = new String((srs.getString("price"))); //가격정보 저장하기
					busan_money[i] = price[i];
				}
				if(n != "") {
					number[i] =  new String((srs.getString("number"))); //비행기 번호를 받아와서 밑에 buypage로 넘겨준다
					busan_numstr[i] = number[i];
					
				}
				if(e != "") {
					busan_seat[i] = new String((srs.getString("seattype"))); //좌석정보 
				}
				i++;
				if(i == 10)
					i = 0;
			}
		}
		public Kr_AirBusan() {
			Container pen = getContentPane();
			pen.setLayout(null);
			
			Connection conn;
			Statement stmt = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gimhaeairport?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","1457");
				stmt = conn.createStatement();
				ResultSet srs = stmt.executeQuery("select start, finish, price, number, seattype from gimpo where airplane = '에어부산' AND date ='" + datenum + "'");
				data(srs, "start", "finish", "price","number","seattype");
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			} catch (SQLException e) {
				System.out.println("SQL 실행 에러");
			}
			
			JButton back = new JButton(new ImageIcon("images/back.png"));
			back.setSize(80, 73);
			back.setLocation(1300, 10);
			back.setBackground(new Color(240, 240, 240));
			back.setBorderPainted(false);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					pen.removeAll();
					pen.revalidate();
					pen.repaint();
					pen.add(new date());
				}
			});
			pen.add(back);
			
			ImageIcon busan = new ImageIcon("images/busan.jpg");
			JLabel busan2 = new JLabel(busan);
			busan2.setSize(300,100);
			busan2.setLocation(100,95);
			
			for(int i=0; i<box.length; i++) {
				box[i] = new JButton();
				box[i].setEnabled(false);
				box[i].setBackground(Color.black);
				box[i].setBounds(x,y,z,v);
				
				y += 120;
			}
			pen.add(busan2);
			pen.add(box[0]);
			
			for(int i=0; i<buy.length; i++) { //여기는 옆에 구매하기 버튼 만드는곳이다.
				buy[i] = new JButton("구매하기 : " + price[i]);
				buy[i].setSize(150,70);
				buy[i].setLocation(280, buy1);
				buy[i].setToolTipText(Integer.toString(i)); 
				buy1 += 120;
				ToolTipManager m = ToolTipManager.sharedInstance();
				m.setEnabled(false);
				buy[i].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						JButton btn = (JButton)e.getSource();
						btninfo = Integer.parseInt(btn.getToolTipText());
						
						pen.removeAll();
						pen.revalidate();
						pen.repaint();
						pen.add(new Kr_AirBusaninfo());
						
					}
				});
			}
			
			for(int i = 0; i<buy.length; i++) {
				for(int j=0; j<la.length; j++) {
					if(j == 0) {
						la[j] = new JLabel(str[j] + startp);
						
					}
					if(j == 1) {
						la[j] = new JLabel(str[j] + lastp);
					}
					if(j == 2) {
						la[j] = new JLabel(str[j] + start[i]);
					}
					if(j == 3) {
						la[j] = new JLabel(str[j] + finish[i]);
					}
					la[j].setSize(120,120);
					la[j].setFont(new Font("맑은고딕", Font.BOLD, 15));
					la[j].setForeground(Color.white);
					la[j].setLocation(70,(165 + (i * 120)) + (j * 25));
					pen.add(la[j]);
				}
				pen.add(buy[i]);
				pen.add(box[i+1]);
			}
		}
	}
	class Kr_AirBusaninfo extends JPanel{
		private JButton [][][][] btn = new JButton[7][5][5][6]; //3중배열 처음 5는 버튼, 5는 y축 6은 x축, 7은 날짜
		private int x=320,y=301;
		private ImageIcon [] icon = {
				new ImageIcon("images/chair2.png"),
				new ImageIcon("images/nchair.png")
		};

		public Kr_AirBusaninfo() {
			
			Container c = getContentPane();
			c.setLayout(null);
			
			JButton back = new JButton(new ImageIcon("images/back.png")); //뒤로가기 버튼
			back.setSize(80, 73);
			back.setLocation(1300, 10);
			back.setBackground(new Color(240, 240, 240));
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					c.removeAll();
					c.revalidate();
					c.repaint();
					c.add(new Kr_AirBusan());
					c.add(new Kr_koreaair());
				}
			});
			c.add(back);
			
			ImageIcon icons = new ImageIcon("images/4.jpg");
			JLabel main = new JLabel(icons);
			main.setSize(1400,1000);
			main.setLocation(0,0);
			JLabel la = new JLabel("좌석표");
			la.setFont(new Font("맑은고딕", Font.PLAIN,30));
			la.setSize(100,100);
			la.setLocation(650,10);
			
			c.add(la);
			
			for(int o=0; o<7; o++) {
				if(datenum == (o+21)) {
					for(int z = 0; z<5; z++) {
						if(btninfo == z) {
							for(int a=z; a<5; a++) {
								for(int i=0; i<5; i++) {
									
									if(i == 1) {
										y += 100;
										x = 320;
									}
									else if (i == 2) {
										y += 100;
										x = 320;
									}
									else if (i == 3) {
										y += 100;
										x = 320;
									}
									else if (i == 4) {
										y += 100;
										x = 320;
									}
									
									for(int j=0; j<6; j++) {
										
										btn[o][a][i][j] = new JButton(icon[0]);
										btn[o][a][i][j].setSize(90,90);
										btn[o][a][i][j].setBorderPainted(false);
										btn[o][a][i][j].setBackground(Color.white);
										btn[o][a][i][j].setLocation(x,y);					
										btn[o][a][i][j].setToolTipText(Integer.toString(o)+Integer.toString(a)+Integer.toString(i)+Integer.toString(j));

										if(check[o][a][i][j] == true) 
											btn[o][a][i][j].setIcon(icon[1]); 

										if(j == 2) {
											x += 200;
										}
										
										c.add(btn[o][a][i][j]);
										
										btn[o][a][i][j].addMouseListener(new MouseAdapter() {
											
											public void mouseExited(MouseEvent e) {
												JButton btns = (JButton)e.getSource();
												
											}
											public void mousePressed(MouseEvent e) {
												JButton btns = (JButton)e.getSource();
												
												sr = btns.getToolTipText();
												System.out.println(sr);
												
												if(btns.getIcon() == icon[0]) {
													c.removeAll();
													c.revalidate();
													c.repaint();
													c.add(new buypage());
												}
											}
										});
										x += 100;
									}
								}
								c.add(main);
								return; //??
							}
						}
					}
				}
			}
		}
		class buypage extends JPanel{
			private String [] str = {"김해 → ", "김포", "에어부산 "," 번 항공기", 
					"출발 시간 : ", " ~ 도착 시간 : ","좌석등급 : ", 
							"예약상황 : OK","항공기 번호 : "};
			private JLabel [] la = new JLabel[7];
			private int x=80 ,y=55;
  			public buypage() {
				Container c = getContentPane();
				c.setLayout(null);
				
				JButton back = new JButton(new ImageIcon("images/back.png")); //뒤로가기 버튼
				back.setSize(80, 73);
				back.setLocation(1300, 10);
				back.setBackground(new Color(240, 240, 240));
				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b = (JButton)e.getSource();
						c.removeAll();
						c.revalidate();
						c.repaint();
						c.add(new Kr_AirBusaninfo());
					
					}
				});
				c.add(back);
				
				JButton background = new JButton();
				background.setSize(1200,650);
				background.setLocation(50,35);
				background.setBackground(Color.white);
				background.setEnabled(false);
				background.setBorderPainted(false);
				
				ImageIcon b = new ImageIcon("images/smallbusan.jpg");
				JLabel busan = new JLabel(b);
				busan.setSize(50,50);
				busan.setLocation(85,125);
				
				JButton bg1 = new JButton();
				bg1.setSize(1160,150);
				bg1.setLocation(70, 55);
				bg1.setBackground(new Color(255,198,198));
				bg1.setEnabled(false);
				bg1.setBorderPainted(false);

				JButton bg2 = new JButton();
				bg2.setSize(1160,250);
				bg2.setLocation(70,360);
				bg2.setBackground(new Color(147,204,141));
				bg2.setEnabled(false);
				bg2.setBorderPainted(false);
				
				for(int i=0; i<la.length; i++) { 
					la[i] = new JLabel();
					la[i].setSize(100,100);
					la[i].setLocation(x,y); //x,y 초기값 80 60
					la[i].setText(str[i]);
					la[i].setFont(new Font("맑은 고딕",Font.BOLD, 20));
					
					if(i == 1) {
						la[i].setForeground(Color.red);
						la[i].setLocation(155,55);
					}
					
					if(i == 2) { //에어부산 + 8888 번 항공기
						la[i].setSize(240,240);
						la[i].setLocation(140,28);

						for(int j=0; j<5; j++) {
							
							if(btninfo == j) {
								la[i].setText(str[i] + busan_numstr[j] + str[i+1]);
							}
						}
					}
					
					if(i == 3) { //출발시간 + 도착시간
						la[i].setSize(380,380);
						la[i].setLocation(80,50);

						for(int j=0; j<5; j++) {
							if(btninfo == j) {
								la[i].setText(str[i+1] + busan_go[j] + str[i+2] + busan_end[j]);
							}
						}
					}
					if(i == 4) { //좌석등급
						la[i].setSize(160,160);
						la[i].setLocation(80,240);
										
						for(int j=0; j<5; j++) {
							if(btninfo == j) {
								la[i].setText(str[i+2] + busan_seat[j]);
							}
						}
					}
					if(i == 5) { //예약상황
						la[i].setSize(160,160);
						la[i].setLocation(890,240);
						la[i].setForeground(Color.red);
						la[i].setText(str[i+2]);
						
					}
					if(i == 6) { //항공기 번호
						la[i].setSize(200,200);
						la[i].setLocation(80,180);

						for(int j=0; j<5; j++) {
							if(btninfo == j) {
								la[i].setText(str[i+2] + busan_numstr[j]);
							}
						}
					}
					
					c.add(la[i]);
				}
				
				JButton buybtn = new JButton("예매하기");
				buybtn.setSize(90,50);
				buybtn.setLocation(600,620);
				
				buybtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int result = JOptionPane.showConfirmDialog(new buypage(), "예매 하시겠습니까?", "예매하기", JOptionPane.YES_NO_OPTION);
						int o,a,b,d;
						if(result == JOptionPane.YES_OPTION) {

							while(true) {
								
								o = Integer.parseInt(sr.substring(0,1));
								a = Integer.parseInt(sr.substring(1,2));
								b = Integer.parseInt(sr.substring(2,3));
								d = Integer.parseInt(sr.substring(3,4));
								
								check[o][a][b][d] = true;
								
								break;
							}
							c.removeAll();
							c.revalidate();
							c.repaint();
							c.add(new Kr_AirBusaninfo());
							
						}
						else if(result == JOptionPane.NO_OPTION) {

						}
					}
				});
				c.add(busan);
				c.add(bg1);
				c.add(bg2);
				c.add(buybtn);
				c.add(background);
			}	
		}
	}
	
	class Kr_koreaair extends JPanel{
		private String [] str = { "출발지 : ","도착지 : ","출발시간 : ", "도착시간 : "};
		private String [] number = new String[20];
		private String startp = "김해공항";
		private String lastp = "김포공항";
		private String [] start = new String[20];
		private String [] finish = new String[20];
		private JLabel [] la = new JLabel[4];
		private JButton [] box = new JButton[6];
		
		private int x=500 , y=85 , z=400 , v=120, buy1=230; //buy1은 구매하기버튼의 y좌표를 뜻함
		private JButton [] buy = new JButton[5];
		private String [] price = new String[20];
		
		private void data(ResultSet srs, String s, String f, String p, String n, String e) throws SQLException {
			int i=0;
			while(srs.next()) {
				if(s != "") {
					start[i] = new String((srs.getString("start"))); //출발시간 저장하기
					kor_go[i] = start[i];
				}
				if(f != "") {
					finish[i] = new String((srs.getString("finish"))); //도착시간 저장하기
					kor_end[i] = finish[i];
				}
				if(p != "") {
					price[i] = new String((srs.getString("price"))); //가격정보 저장하기
					kor_money[i] = price[i];
				}
				if(n != "") {
					number[i] =  new String((srs.getString("number"))); //비행기 번호를 받아와서 밑에 buypage로 넘겨준다
					kor_numstr[i] = number[i];
					
				}
				if(e != "") {
					kor_seat[i] = new String((srs.getString("seattype"))); //좌석정보 
				}
				i++;
				if(i == 10)
					i = 0;
			}
		}
		public Kr_koreaair() {
			Container pen = getContentPane();
			pen.setLayout(null);
			
			Connection conn;
			Statement stmt = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gimhaeairport?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","1457");
				stmt = conn.createStatement();
				ResultSet srs = stmt.executeQuery("select start, finish, price, number, seattype from gimpo where airplane = '대한항공' AND date = '"+datenum+"'");
				data(srs, "start", "finish", "price","number", "seattype");
			} catch (ClassNotFoundException e) {
				System.out.println("JDBC 드라이버 로드 에러");
			} catch (SQLException e) {
				System.out.println("SQL 실행 에러");
			}
			
			ImageIcon koreaair = new ImageIcon("images/korea.jpg");
			JLabel korea = new JLabel(koreaair);
			korea.setSize(300,100);
			korea.setLocation(550,95);
			
			for(int i=0; i<box.length; i++) {
				box[i] = new JButton();
				box[i].setEnabled(false);
				box[i].setBackground(Color.black);
				box[i].setBounds(x,y,z,v);
				
				y += 120;
			}
			
			pen.add(korea);
			pen.add(box[0]);
			
			for(int i=0; i<buy.length; i++) { //여기는 옆에 구매하기 버튼 만드는곳이다.
				buy[i] = new JButton("구매하기 : " + price[i]);
				buy[i].setSize(150,70);
				buy[i].setLocation(730, buy1);
				buy[i].setToolTipText(Integer.toString(i+5));
				buy1 += 120;
				buy[i].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						JButton btn = (JButton)e.getSource();
						btninfo = Integer.parseInt(btn.getToolTipText());
				
						pen.removeAll();
						pen.revalidate();
						pen.repaint();
						pen.add(new Kr_koreainfo());
					}
				});
			}
			for(int i = 0; i<buy.length; i++) {
				for(int j=0; j<la.length; j++) {
					if(j == 0) {
						la[j] = new JLabel(str[j] + startp);	
					}
					if(j == 1) {
						la[j] = new JLabel(str[j] + lastp);
					}
					if(j == 2) {
						la[j] = new JLabel(str[j] + start[i]);
					}
					if(j == 3) {
						la[j] = new JLabel(str[j] + finish[i]);
					}
					la[j].setSize(120,120);
					la[j].setFont(new Font("맑은고딕", Font.BOLD, 15));
					la[j].setForeground(Color.white);
					la[j].setLocation(520,(165 + (i * 120)) + (j * 25));
					pen.add(la[j]);
				}
				pen.add(buy[i]);
				pen.add(box[i+1]);
			}
			ToolTipManager m = ToolTipManager.sharedInstance();
			m.setEnabled(false);
		}
	}
	class Kr_koreainfo extends JPanel{
		private JButton [][][][] btn = new JButton[7][10][5][6]; //6크기의 1차원배열이 5개있음
		private int x=320,y=200;
		private ImageIcon [] icon = {
				new ImageIcon("images/chair2.png"),
				new ImageIcon("images/nchair.png")
		};

		public Kr_koreainfo() {
			Container c = getContentPane();
			c.setLayout(null);
			
			JButton back = new JButton(new ImageIcon("images/back.png"));
			back.setSize(80, 73);
			back.setLocation(1300, 10);
			back.setBackground(new Color(240, 240, 240));
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					c.removeAll();
					c.revalidate();
					c.repaint();
					c.add(new Kr_AirBusan());
					c.add(new Kr_koreaair());
				}
			});
			c.add(back);
			
			ImageIcon icons = new ImageIcon("images/4.jpg");
			JLabel main = new JLabel(icons);
			main.setSize(1400,1000);
			main.setLocation(0,0);
			JLabel la = new JLabel("좌석표");
			la.setFont(new Font("맑은고딕", Font.PLAIN,30));
			la.setSize(100,100);
			la.setLocation(650,10);
			
			c.add(la);
			
			for(int o=0; o<7; o++) {
				if(datenum == o+21) {
					for(int z = 0; z<10; z++) {
						if(btninfo == z) {
							for(int a=z; a<10; a++) {
								for(int i=0; i<5; i++) {
									if(i == 1) {
										y += 100;
										x = 320;
									}
									else if (i == 2) {
										y += 100;
										x = 320;
									}
									else if (i == 3) {
										y += 100;
										x = 320;
									}
									else if (i == 4) {
										y += 100;
										x = 320;
									}
									
									for(int j=0; j<6; j++) {
										
										btn[o][a][i][j] = new JButton(icon[0]);
										btn[o][a][i][j].setSize(90,90);
										btn[o][a][i][j].setBorderPainted(false);
										btn[o][a][i][j].setBackground(Color.white);
										btn[o][a][i][j].setLocation(x,y);
										btn[o][a][i][j].setToolTipText(Integer.toString(o)+Integer.toString(a)+Integer.toString(i)+Integer.toString(j));
										
										if(check[o][a][i][j] == true) 
											btn[o][a][i][j].setIcon(icon[1]); 

										if(j == 2) {
											x += 200;
										}
										
										c.add(btn[o][a][i][j]);
										
										btn[o][a][i][j].addMouseListener(new MouseAdapter() {
											
											public void mouseExited(MouseEvent e) {
												JButton btns = (JButton)e.getSource();
											}
											public void mousePressed(MouseEvent e) {
												JButton btns = (JButton)e.getSource();
												
												sr = btns.getToolTipText();
												System.out.println(sr);
												
												if(btns.getIcon() == icon[0]) {
													c.removeAll();
													c.revalidate();
													c.repaint();
													c.add(new buypage());
												}
											}
										});
										x += 100;
									}
								}
								c.add(main);
								return; //??
							}
							return;
						}
					}
				}
			}
			
		}
		class buypage extends JPanel{
			private String [] str = {"김해 → ", "김포", "에어부산 "," 번 항공기", 
					"출발 시간 : ", " ~ 도착 시간 : ","좌석등급 : ", 
							"예약상황 : OK","항공기 번호 : "};
			private JLabel [] la = new JLabel[7];
			private int x=80 ,y=55;
  			public buypage() {
				Container c = getContentPane();
				c.setLayout(null);
				
				JButton back = new JButton(new ImageIcon("images/back.png")); //뒤로가기 버튼
				back.setSize(80, 73);
				back.setLocation(1300, 10);
				back.setBackground(new Color(240, 240, 240));
				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b = (JButton)e.getSource();
						c.removeAll();
						c.revalidate();
						c.repaint();
						c.add(new Kr_koreainfo());
					}
				});
				c.add(back);
				
				JButton background = new JButton();
				background.setSize(1200,650);
				background.setLocation(50,35);
				background.setBackground(Color.white);
				background.setEnabled(false);
				background.setBorderPainted(false);
				
				ImageIcon b = new ImageIcon("images/smallkor.jpg");
				JLabel busan = new JLabel(b);
				busan.setSize(50,50);
				busan.setLocation(85,125);
				
				JButton bg1 = new JButton();
				bg1.setSize(1160,150);
				bg1.setLocation(70, 55);
				bg1.setBackground(new Color(255,198,198));
				bg1.setEnabled(false);
				bg1.setBorderPainted(false);

				JButton bg2 = new JButton();
				bg2.setSize(1160,250);
				bg2.setLocation(70,360);
				bg2.setBackground(new Color(147,204,141));
				bg2.setEnabled(false);
				bg2.setBorderPainted(false);
				
				for(int i=0; i<la.length; i++) { 
					la[i] = new JLabel();
					la[i].setSize(100,100);
					la[i].setLocation(x,y); //x,y 초기값 80 60
					la[i].setText(str[i]);
					la[i].setFont(new Font("맑은 고딕",Font.BOLD, 20));
					
					if(i == 1) {
						la[i].setForeground(Color.red);
						la[i].setLocation(155,55);
					}
					
					if(i == 2) {
						la[i].setSize(240,240);
						la[i].setLocation(140,28);

						for(int j=0; j<5; j++) {
							
							if(btninfo == j+5) {
								la[i].setText(str[i] + kor_numstr[j] + str[i+1]);
							}
						}
					}
					
					if(i == 3) { //출발시간 + 도착시간
						la[i].setSize(380,380);
						la[i].setLocation(80,50);

						for(int j=0; j<5; j++) {
							if(btninfo == j+5) {
								la[i].setText(str[i+1] +kor_go[j] + str[i+2] + kor_end[j]);
							}
						}
					}
					if(i == 4) { //좌석등급
						la[i].setSize(160,160);
						la[i].setLocation(80,240);
										
						for(int j=0; j<5; j++) {
							if(btninfo == j+5) {
								la[i].setText(str[i+2] + kor_seat[j]);
							}
						}
					}
					if(i == 5) { //예약상황
						la[i].setSize(160,160);
						la[i].setLocation(890,240);
						la[i].setForeground(Color.red);
						la[i].setText(str[i+2]);
						
					}
					if(i == 6) { //항공기 번호
						la[i].setSize(200,200);
						la[i].setLocation(80,180);

						for(int j=0; j<5; j++) {
							if(btninfo == j+5) {
								la[i].setText(str[i+2] + kor_numstr[j]);
							}
						}
					}
					
					c.add(la[i]);
				}
				
				JButton buybtn = new JButton("예매하기");
				buybtn.setSize(90,50);
				buybtn.setLocation(600,620);
				
				buybtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int result = JOptionPane.showConfirmDialog(new buypage(), "예매 하시겠습니까?", "예매하기", JOptionPane.YES_NO_OPTION);
						int o,a,b,d;
						if(result == JOptionPane.YES_OPTION) {

							while(true) {
								
								o = Integer.parseInt(sr.substring(0,1));
								a = Integer.parseInt(sr.substring(1,2));
								b = Integer.parseInt(sr.substring(2,3));
								d = Integer.parseInt(sr.substring(3,4));
								
								check[o][a][b][d] = true;
								
								break;
							}
							c.removeAll();
							c.revalidate();
							c.repaint();
							c.add(new Kr_koreainfo());
						}
						else if(result == JOptionPane.NO_OPTION) { }
					}
				});
				c.add(busan);
				c.add(bg1);
				c.add(bg2);
				c.add(buybtn);
				c.add(background);
			}	
		}
	}
/////////////////////////////////////////////////////////////////////////////////
//밑에서 부터는 제주 가는거 예약하는 페이지//
////////////////////////////////////////////////////////////////////////////////

	class Jj_AirBusan extends JPanel{  //제일큰 패널이다
		private String [] str = { "출발지 : ","도착지 : ","출발시간 : ", "도착시간 : "};
		private String [] number = new String[20];
		private String startp = "김해공항";
		private String lastp = "제주공항";
		private String [] start = new String[20];
		private String [] finish = new String[20];
		private JLabel [] la = new JLabel[4];
		private JButton [] box = new JButton[6];
		
		private int x=50 , y=85 , z=400 , v=120, buy1=230; //buy1은 구매하기버튼의 y좌표를 뜻함
		private JButton [] buy = new JButton[5];
		private String [] price = new String[20];
		
		private void data(ResultSet srs, String s, String f, String p, String n, String e) throws SQLException {
			int i=0;
			while(srs.next()) {
				if(s != "") {
					start[i] = new String((srs.getString("start"))); //출발시간 저장하기
					busanjeju_go[i] = start[i];
				}
				if(f != "") {
					finish[i] = new String((srs.getString("finish"))); //도착시간 저장하기
					busanjeju_end[i] = finish[i];
				}
				if(p != "") {
					price[i] = new String((srs.getString("price"))); //가격정보 저장하기
					busanjeju_money[i] = price[i];
				}
				if(n != "") {
					number[i] =  new String((srs.getString("number"))); //비행기 번호를 받아와서 밑에 buypage로 넘겨준다
					busanjeju_numstr[i] = number[i];
					
				}
				if(e != "") {
					busanjeju_seat[i] = new String((srs.getString("seattype"))); //좌석정보 
				}
				i++;
				if(i == 10)
					i = 0;
			}
		}
		public Jj_AirBusan() {
			Container pen = getContentPane();
			pen.setLayout(null);
			
			Connection conn;
			Statement stmt = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gimhaeairport?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","1457");
				stmt = conn.createStatement();
				ResultSet srs = stmt.executeQuery("select start, finish, price,number,seattype from jeju where airplane = '에어부산'AND date = '"+datenum+"'");
				data(srs, "start", "finish", "price","number","seattype");
			} catch (ClassNotFoundException e) {
				System.out.println("JDBC 드라이버 로드 에러");
			} catch (SQLException e) {
				System.out.println(e);
			}
			
			JButton back = new JButton(new ImageIcon("images/back.png"));
			back.setSize(80, 73);
			back.setLocation(1300, 10);
			back.setBackground(new Color(240, 240, 240));
			back.setBorderPainted(false);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					pen.removeAll();
					pen.revalidate();
					pen.repaint();
					pen.add(new date());
				}
			});
			pen.add(back);
			
			ImageIcon busan = new ImageIcon("images/busan.jpg");
			JLabel busan2 = new JLabel(busan);
			busan2.setSize(300,100);
			busan2.setLocation(100,95);
			
			for(int i=0; i<box.length; i++) {
				box[i] = new JButton();
				box[i].setEnabled(false);
				box[i].setBackground(Color.black);
				box[i].setBounds(x,y,z,v);
				
				y += 120;
			}
			pen.add(busan2);
			pen.add(box[0]);
			
			for(int i=0; i<buy.length; i++) { //여기는 옆에 구매하기 버튼 만드는곳이다.
				buy[i] = new JButton("구매하기 : " + price[i]);
				buy[i].setSize(150,70);
				buy[i].setLocation(280, buy1);
				buy[i].setToolTipText(Integer.toString(i+10)); 
				buy1 += 120;
				ToolTipManager m = ToolTipManager.sharedInstance();
				m.setEnabled(false);
				buy[i].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						JButton btn = (JButton)e.getSource();
						btninfo = Integer.parseInt(btn.getToolTipText());
						
						pen.removeAll();
						pen.revalidate();
						pen.repaint();
						pen.add(new Jj_AirBusaninfo());
					}
				});
			}
			
			for(int i = 0; i<buy.length; i++) {
				for(int j=0; j<la.length; j++) {
					if(j == 0) {
						la[j] = new JLabel(str[j] + startp);
						
					}
					if(j == 1) {
						la[j] = new JLabel(str[j] + lastp);
					}
					if(j == 2) {
						la[j] = new JLabel(str[j] + start[i]);
					}
					if(j == 3) {
						la[j] = new JLabel(str[j] + finish[i]);
					}
					la[j].setSize(120,120);
					la[j].setFont(new Font("맑은고딕", Font.BOLD, 15));
					la[j].setForeground(Color.white);
					la[j].setLocation(70,(165 + (i * 120)) + (j * 25));
					pen.add(la[j]);
				}
				pen.add(buy[i]);
				pen.add(box[i+1]);
			}
		}
	}
	class Jj_AirBusaninfo extends JPanel{
		private JButton [][][][] btn = new JButton[7][15][5][6]; //6크기의 1차원배열이 5개있음
		private int x=320,y=200;
		private ImageIcon [] icon = {
				new ImageIcon("images/chair2.png"),
				new ImageIcon("images/nchair.png")
		};

		public Jj_AirBusaninfo() {
			Container c = getContentPane();
			c.setLayout(null);
			
			JButton back = new JButton(new ImageIcon("images/back.png"));
			back.setSize(80, 73);
			back.setLocation(1300, 10);
			back.setBackground(new Color(240, 240, 240));
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					c.removeAll();
					c.revalidate();
					c.repaint();
					c.add(new Jj_AirBusan());
					c.add(new Jj_koreaair());
					c.add(new Jj_jejuair());
				}
			});
			c.add(back);
			
			ImageIcon icons = new ImageIcon("images/4.jpg");
			JLabel main = new JLabel(icons);
			main.setSize(1400,1000);
			main.setLocation(0,0);
			JLabel la = new JLabel("좌석표");
			la.setFont(new Font("맑은고딕", Font.PLAIN,30));
			la.setSize(100,100);
			la.setLocation(650,10);
			
			c.add(la);
			for(int o=0; o<7; o++) {
				if(datenum == o+21) {
					for(int z = 0; z<15; z++) {
						if(btninfo == z) {
							for(int a=z; a<15; a++) {
								for(int i=0; i<5; i++) {
									if(i == 1) {
										y += 100;
										x = 320;
									}
									else if (i == 2) {
										y += 100;
										x = 320;
									}
									else if (i == 3) {
										y += 100;
										x = 320;
									}
									else if (i == 4) {
										y += 100;
										x = 320;
									}
									
									for(int j=0; j<6; j++) {
										
										btn[o][a][i][j] = new JButton(icon[0]);
										btn[o][a][i][j].setSize(90,90);
										btn[o][a][i][j].setBorderPainted(false);
										btn[o][a][i][j].setBackground(Color.white);
										btn[o][a][i][j].setLocation(x,y);
										btn[o][a][i][j].setToolTipText(Integer.toString(o)+Integer.toString(a)+Integer.toString(i)+Integer.toString(j));
										
										if(check[o][a][i][j] == true) 
											btn[o][a][i][j].setIcon(icon[1]); 

										if(j == 2) {
											x += 200;
										}
										
										c.add(btn[o][a][i][j]);
										
										btn[o][a][i][j].addMouseListener(new MouseAdapter() {
											
											public void mouseExited(MouseEvent e) {
												JButton btns = (JButton)e.getSource();
											}
											public void mousePressed(MouseEvent e) {
												JButton btns = (JButton)e.getSource();
												
												sr = btns.getToolTipText();
												System.out.println(sr);
												
												if(btns.getIcon() == icon[0]) {
													c.removeAll();
													c.revalidate();
													c.repaint();
													c.add(new buypage());
												}
											}
										});
										x += 100;
									}
								}
								c.add(main);
								return; //??
							}
							return;
						}
					}
				}
			}

		}
		class buypage extends JPanel{
			private String [] str = {"김해 → ", "제주", "에어부산 "," 번 항공기", 
					"출발 시간 : ", " ~ 도착 시간 : ","좌석등급 : ", 
							"예약상황 : OK","항공기 번호 : "};
			private JLabel [] la = new JLabel[7];
			private int x=80 ,y=55;
  			public buypage() {
				Container c = getContentPane();
				c.setLayout(null);
					
				JButton back = new JButton(new ImageIcon("images/back.png")); //뒤로가기 버튼
				back.setSize(80, 73);
				back.setLocation(1300, 10);
				back.setBackground(new Color(240, 240, 240));
				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b = (JButton)e.getSource();
						c.removeAll();
						c.revalidate();
						c.repaint();
						c.add(new Jj_AirBusaninfo());
					
					}
				});
				c.add(back);
				
				JButton background = new JButton();
				background.setSize(1200,650);
				background.setLocation(50,35);
				background.setBackground(Color.white);
				background.setEnabled(false);
				background.setBorderPainted(false);
				
				ImageIcon b = new ImageIcon("images/smallbusan.jpg");
				JLabel busan = new JLabel(b);
				busan.setSize(50,50);
				busan.setLocation(85,125);
				
				JButton bg1 = new JButton();
				bg1.setSize(1160,150);
				bg1.setLocation(70, 55);
				bg1.setBackground(new Color(255,198,198));
				bg1.setEnabled(false);
				bg1.setBorderPainted(false);

				JButton bg2 = new JButton();
				bg2.setSize(1160,250);
				bg2.setLocation(70,360);
				bg2.setBackground(new Color(147,204,141));
				bg2.setEnabled(false);
				bg2.setBorderPainted(false);
				
				for(int i=0; i<la.length; i++) { 
					la[i] = new JLabel();
					la[i].setSize(100,100);
					la[i].setLocation(x,y); //x,y 초기값 80 60
					la[i].setText(str[i]);
					la[i].setFont(new Font("맑은 고딕",Font.BOLD, 20));
					
					if(i == 1) {
						la[i].setForeground(Color.red);
						la[i].setLocation(155,55);
					}
					
					if(i == 2) { //에어부산 + 8888 번 항공기
						la[i].setSize(240,240);
						la[i].setLocation(140,28);

						for(int j=0; j<5; j++) {
							
							if(btninfo == j+10) { //btninfo = 15 16 17 18 19
								la[i].setText(str[i] + busanjeju_numstr[j] + str[i+1]);
							}
						}
					}
					
					if(i == 3) { //출발시간 + 도착시간
						la[i].setSize(380,380);
						la[i].setLocation(80,50);

						for(int j=0; j<5; j++) {
							if(btninfo == j+10) {
								la[i].setText(str[i+1] + busanjeju_go[j] + str[i+2] + busanjeju_end[j]);
							}
						}
					}
					if(i == 4) { //좌석등급
						la[i].setSize(160,160);
						la[i].setLocation(80,240);
										
						for(int j=0; j<5; j++) {
							if(btninfo == j+10) {
								la[i].setText(str[i+2] + busanjeju_seat[j]);
							}
						}
					}
					if(i == 5) { //예약상황
						la[i].setSize(160,160);
						la[i].setLocation(890,240);
						la[i].setForeground(Color.red);
						la[i].setText(str[i+2]);
						
					}
					if(i == 6) { //항공기 번호
						la[i].setSize(200,200);
						la[i].setLocation(80,180);

						for(int j=0; j<5; j++) {
							if(btninfo == j+10) {
								la[i].setText(str[i+2] + busanjeju_numstr[j]);
							}
						}
					}
					c.add(la[i]);
				}
				
				JButton buybtn = new JButton("예매하기");
				buybtn.setSize(90,50);
				buybtn.setLocation(600,620);
				buybtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int result = JOptionPane.showConfirmDialog(new buypage(), "예매 하시겠습니까?", "예매하기", JOptionPane.YES_NO_OPTION);
						int o,a,b,d;
						if(result == JOptionPane.YES_OPTION) {

							while(true) {
								
								o = Integer.parseInt(sr.substring(0,1));
								a = Integer.parseInt(sr.substring(1,3));
								b = Integer.parseInt(sr.substring(3,4));
								d = Integer.parseInt(sr.substring(4,5));
								
								check[o][a][b][d] = true;
								
								break;
							}
							c.removeAll();
							c.revalidate();
							c.repaint();
							c.add(new Jj_AirBusaninfo());
	
						}
						else if(result == JOptionPane.NO_OPTION) {

						}
					}
				});
				c.add(busan);
				c.add(bg1);
				c.add(bg2);
				c.add(buybtn);
				c.add(background);
			}
		}	
	}

	class Jj_koreaair extends JPanel{  //제일큰 패널이다
		private String [] str = { "출발지 : ","도착지 : ","출발시간 : ", "도착시간 : "};
		private String [] number = new String[20];
		private String startp = "김해공항";
		private String lastp = "제주공항";
		private String [] start = new String[20];
		private String [] finish = new String[20];
		private JLabel [] la = new JLabel[4];
		private JButton [] box = new JButton[6];
		
		private int x=500 , y=85 , z=400 , v=120, buy1=230; //buy1은 구매하기버튼의 y좌표를 뜻함
		private JButton [] buy = new JButton[5];
		private String [] price = new String[20];
		
		private void data(ResultSet srs, String s, String f, String p, String n, String e) throws SQLException {
			int i=0;
			while(srs.next()) {
				if(s != "") {
					start[i] = new String((srs.getString("start"))); //출발시간 저장하기
					koreajeju_go[i] = start[i];
				}
				if(f != "") {
					finish[i] = new String((srs.getString("finish"))); //도착시간 저장하기
					koreajeju_end[i] = finish[i];
				}
				if(p != "") {
					price[i] = new String((srs.getString("price"))); //가격정보 저장하기
					koreajeju_money[i] = price[i];
				}
				if(n != "") {
					number[i] =  new String((srs.getString("number"))); //비행기 번호를 받아와서 밑에 buypage로 넘겨준다
					koreajeju_numstr[i] = number[i];
					
				}
				if(e != "") {
					koreajeju_seat[i] = new String((srs.getString("seattype"))); //좌석정보 
				}
				i++;
				if(i == 10)
					i = 0;
			}
		}
		
		public Jj_koreaair() {
			Container pen = getContentPane();
			pen.setLayout(null);
			
			Connection conn;
			Statement stmt = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gimhaeairport?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","1457");
				stmt = conn.createStatement();
				ResultSet srs = stmt.executeQuery("select start, finish, price,number,seattype  from jeju where airplane = '대한항공'AND date = '"+datenum+"'");
				data(srs,  "start", "finish", "price","number", "seattype");
			} catch (ClassNotFoundException e) {
				System.out.println("JDBC 드라이버 로드 에러");
			} catch (SQLException e) {
				System.out.println("SQL 실행 에러");
			}
			
			ImageIcon busan = new ImageIcon("images/korea.jpg");
			JLabel busan2 = new JLabel(busan);
			busan2.setSize(300,100);
			busan2.setLocation(550,95);
			
			for(int i=0; i<box.length; i++) {
				box[i] = new JButton();
				box[i].setEnabled(false);
				box[i].setBackground(Color.black);
				box[i].setBounds(x,y,z,v);
				
				y += 120;
			}
			pen.add(busan2);
			pen.add(box[0]);
			
			for(int i=0; i<buy.length; i++) { //여기는 옆에 구매하기 버튼 만드는곳이다.
				buy[i] = new JButton("구매하기 : " + price[i]);
				buy[i].setSize(150,70);
				buy[i].setLocation(730, buy1);
				buy[i].setToolTipText(Integer.toString(i+15)); 
				buy1 += 120;
				ToolTipManager m = ToolTipManager.sharedInstance();
				m.setEnabled(false);
				buy[i].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						JButton btn = (JButton)e.getSource();
						btninfo = Integer.parseInt(btn.getToolTipText());
						pen.removeAll();
						pen.revalidate();
						pen.repaint();
						pen.add(new Jj_koreainfo());
					}
				});
			}
			
			for(int i = 0; i<buy.length; i++) {
				for(int j=0; j<la.length; j++) {
					if(j == 0) {
						la[j] = new JLabel(str[j] + startp);
						
					}
					if(j == 1) {
						la[j] = new JLabel(str[j] + lastp);
					}
					if(j == 2) {
						la[j] = new JLabel(str[j] + start[i]);
					}
					if(j == 3) {
						la[j] = new JLabel(str[j] + finish[i]);
					}
					la[j].setSize(120,120);
					la[j].setFont(new Font("맑은고딕", Font.BOLD, 15));
					la[j].setForeground(Color.white);
					la[j].setLocation(520,(165 + (i * 120)) + (j * 25));
					pen.add(la[j]);
				}
				pen.add(buy[i]);
				pen.add(box[i+1]);
			}
		}
	}
	class Jj_koreainfo extends JPanel{
		private JButton [][][][] btn = new JButton[7][20][5][6]; //6크기의 1차원배열이 5개있음
		private int x=320,y=200;
		private ImageIcon [] icon = {
				new ImageIcon("images/chair2.png"),
				new ImageIcon("images/nchair.png")
		};

		public Jj_koreainfo() {
			Container c = getContentPane();
			c.setLayout(null);
			
			JButton back = new JButton(new ImageIcon("images/back.png"));
			back.setSize(80, 73);
			back.setLocation(1300, 10);
			back.setBackground(new Color(240, 240, 240));
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					c.removeAll();
					c.revalidate();
					c.repaint();
					c.add(new Jj_AirBusan());
					c.add(new Jj_koreaair());
					c.add(new Jj_jejuair());
				}
			});
			c.add(back);
			
			ImageIcon icons = new ImageIcon("images/4.jpg");
			JLabel main = new JLabel(icons);
			main.setSize(1400,1000);
			main.setLocation(0,0);
			JLabel la = new JLabel("좌석표");
			la.setFont(new Font("맑은고딕", Font.PLAIN,30));
			la.setSize(100,100);
			la.setLocation(650,10);
			
			c.add(la);
			
			for(int o=0; o<7; o++) {
				if(datenum == o+21) {
					for(int z = 0; z<20; z++) {
						if(btninfo == z) {
							for(int a=z; a<20; a++) {
								for(int i=0; i<5; i++) {
									if(i == 1) {
										y += 100;
										x = 320;
									}
									else if (i == 2) {
										y += 100;
										x = 320;
									}
									else if (i == 3) {
										y += 100;
										x = 320;
									}
									else if (i == 4) {
										y += 100;
										x = 320;
									}
									
									for(int j=0; j<6; j++) {
										
										btn[o][a][i][j] = new JButton(icon[0]);
										btn[o][a][i][j].setSize(90,90);
										btn[o][a][i][j].setBorderPainted(false);
										btn[o][a][i][j].setBackground(Color.white);
										btn[o][a][i][j].setLocation(x,y);
										btn[o][a][i][j].setToolTipText(Integer.toString(o)+Integer.toString(a)+Integer.toString(i)+Integer.toString(j));
										
										if(check[o][a][i][j] == true) 
											btn[o][a][i][j].setIcon(icon[1]); 

										if(j == 2) {
											x += 200;
										}
										
										c.add(btn[o][a][i][j]);
										
										btn[o][a][i][j].addMouseListener(new MouseAdapter() {
											
											public void mouseExited(MouseEvent e) {
												JButton btns = (JButton)e.getSource();
											}
											public void mousePressed(MouseEvent e) {
												JButton btns = (JButton)e.getSource();
												
												sr = btns.getToolTipText();
												System.out.println(sr);
												
												if(btns.getIcon() == icon[0]) {
													c.removeAll();
													c.revalidate();
													c.repaint();
													c.add(new buypage());
												}
											}
										});
										x += 100;
									}
								}
								c.add(main);
								return; //??
							}
							return;
						}
					}
				}
			}
		}
	
		class buypage extends JPanel{
			private String [] str = {"김해 → ", "제주", "대한항공 "," 번 항공기", 
					"출발 시간 : ", " ~ 도착 시간 : ","좌석등급 : ", 
							"예약상황 : OK","항공기 번호 : "};
			private JLabel [] la = new JLabel[7];
			private int x=80 ,y=55;
  			public buypage() {
				Container c = getContentPane();
				c.setLayout(null);
				
				JButton back = new JButton(new ImageIcon("images/back.png")); //뒤로가기 버튼
				back.setSize(80, 73);
				back.setLocation(1300, 10);
				back.setBackground(new Color(240, 240, 240));
				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b = (JButton)e.getSource();
						c.removeAll();
						c.revalidate();
						c.repaint();
						c.add(new Jj_koreainfo());
					}
				});
				c.add(back);
				
				JButton background = new JButton();
				background.setSize(1200,650);
				background.setLocation(50,35);
				background.setBackground(Color.white);
				background.setEnabled(false);
				background.setBorderPainted(false);
				
				ImageIcon b = new ImageIcon("images/smallkor.jpg");
				JLabel busan = new JLabel(b);
				busan.setSize(50,50);
				busan.setLocation(85,125);
				
				JButton bg1 = new JButton();
				bg1.setSize(1160,150);
				bg1.setLocation(70, 55);
				bg1.setBackground(new Color(255,198,198));
				bg1.setEnabled(false);
				bg1.setBorderPainted(false);

				JButton bg2 = new JButton();
				bg2.setSize(1160,250);
				bg2.setLocation(70,360);
				bg2.setBackground(new Color(147,204,141));
				bg2.setEnabled(false);
				bg2.setBorderPainted(false);
				
				for(int i=0; i<la.length; i++) { 
					la[i] = new JLabel();
					la[i].setSize(100,100);
					la[i].setLocation(x,y); //x,y 초기값 80 60
					la[i].setText(str[i]);
					la[i].setFont(new Font("맑은 고딕",Font.BOLD, 20));
					
					if(i == 1) {
						la[i].setForeground(Color.red);
						la[i].setLocation(155,55);
					}
					
					if(i == 2) { //에어부산 + 8888 번 항공기
						la[i].setSize(240,240);
						la[i].setLocation(140,28);

						for(int j=0; j<5; j++) {
							
							if(btninfo == j+15) { //btninfo = 15 16 17 18 19
								la[i].setText(str[i] + koreajeju_numstr[j] + str[i+1]);
							}
						}
					}
					
					if(i == 3) { //출발시간 + 도착시간
						la[i].setSize(380,380);
						la[i].setLocation(80,50);

						for(int j=0; j<5; j++) {
							if(btninfo == j+15) {
								la[i].setText(str[i+1] + koreajeju_go[j] + str[i+2] + koreajeju_end[j]);
							}
						}
					}
					if(i == 4) { //좌석등급
						la[i].setSize(160,160);
						la[i].setLocation(80,240);
										
						for(int j=0; j<5; j++) {
							if(btninfo == j+15) {
								la[i].setText(str[i+2] + koreajeju_seat[j]);
							}
						}
					}
					if(i == 5) { //예약상황
						la[i].setSize(160,160);
						la[i].setLocation(890,240);
						la[i].setForeground(Color.red);
						la[i].setText(str[i+2]);
						
					}
					if(i == 6) { //항공기 번호
						la[i].setSize(200,200);
						la[i].setLocation(80,180);

						for(int j=0; j<5; j++) {
							if(btninfo == j+15) {
								la[i].setText(str[i+2] + koreajeju_numstr[j]);
							}
						}
					}
					c.add(la[i]);
				}
				
				JButton buybtn = new JButton("예매하기");
				buybtn.setSize(90,50);
				buybtn.setLocation(600,620);
				
				buybtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int result = JOptionPane.showConfirmDialog(new buypage(), "예매 하시겠습니까?", "예매하기", JOptionPane.YES_NO_OPTION);
						int o,a,b,d;
						if(result == JOptionPane.YES_OPTION) {

							while(true) {
								
								o = Integer.parseInt(sr.substring(0,1));
								a = Integer.parseInt(sr.substring(1,3));
								b = Integer.parseInt(sr.substring(3,4));
								d = Integer.parseInt(sr.substring(4,5));
								
								check[o][a][b][d] = true;
								
								break;
							}
							c.removeAll();
							c.revalidate();
							c.repaint();
							c.add(new Jj_koreainfo());
						}
						else if(result == JOptionPane.NO_OPTION) { }
					}
				});
				c.add(busan);
				c.add(bg1);
				c.add(bg2);
				c.add(buybtn);
				c.add(background);
			}	
		}
	}
	
	class Jj_jejuair extends JPanel{  //제일큰 패널이다
		private String [] str = { "출발지 : ","도착지 : ","출발시간 : ", "도착시간 : "};
		private String [] number = new String[20];
		private String startp = "김해공항";
		private String lastp = "제주공항";
		private String [] start = new String[20];
		private String [] finish = new String[20];
		private JLabel [] la = new JLabel[4];
		private JButton [] box = new JButton[6];
		
		private int x=950 , y=85 , z=400 , v=120, buy1=230; //buy1은 구매하기버튼의 y좌표를 뜻함
		private JButton [] buy = new JButton[5];
		private String [] price = new String[20];
		
		private void data(ResultSet srs, String s, String f, String p, String n, String e) throws SQLException {
			int i=0;
			while(srs.next()) {
				if(s != "") {
					start[i] = new String((srs.getString("start"))); //출발시간 저장하기
					jeju_go[i] = start[i];
				}
				if(f != "") {
					finish[i] = new String((srs.getString("finish"))); //도착시간 저장하기
					jeju_end[i] = finish[i];
				}
				if(p != "") {
					price[i] = new String((srs.getString("price"))); //가격정보 저장하기
					jeju_money[i] = price[i];
				}
				if(n != "") {
					number[i] =  new String((srs.getString("number"))); //비행기 번호를 받아와서 밑에 buypage로 넘겨준다
					jeju_numstr[i] = number[i];
					
				}
				if(e != "") {
					jeju_seat[i] = new String((srs.getString("seattype"))); //좌석정보 
				}
				i++;
				if(i == 10)
					i = 0;
			}
		}
		
		public Jj_jejuair() {
			Container pen = getContentPane();
			pen.setLayout(null);
			
			Connection conn;
			Statement stmt = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gimhaeairport?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","1457");
				stmt = conn.createStatement();
				ResultSet srs = stmt.executeQuery("select start, finish, price ,number,seattype from jeju where airplane = '제주항공'AND date = '"+datenum+"'");
				data(srs, "start", "finish", "price","number","seattype");
			} catch (ClassNotFoundException e) {
				System.out.println("JDBC 드라이버 로드 에러");
			} catch (SQLException e) {
				System.out.println(e);
			}
			
			ImageIcon busan = new ImageIcon("images/jeju.jpg");
			JLabel busan2 = new JLabel(busan);
			busan2.setSize(300,100);
			busan2.setLocation(1000,95);
			
			for(int i=0; i<box.length; i++) {
				box[i] = new JButton();
				box[i].setEnabled(false);
				box[i].setBackground(Color.black);
				box[i].setBounds(x,y,z,v);
				
				y += 120;
			}
			pen.add(busan2);
			pen.add(box[0]);
			
			for(int i=0; i<buy.length; i++) { //여기는 옆에 구매하기 버튼 만드는곳이다.
				buy[i] = new JButton("구매하기 : " + price[i]);
				buy[i].setSize(150,70);
				buy[i].setLocation(1180, buy1);
				buy[i].setToolTipText(Integer.toString(i+20)); 
				buy1 += 120;
				ToolTipManager m = ToolTipManager.sharedInstance();
				m.setEnabled(false);
				buy[i].addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						JButton btn = (JButton)e.getSource();
						btninfo = Integer.parseInt(btn.getToolTipText());
						pen.removeAll();
						pen.revalidate();
						pen.repaint();
						pen.add(new Jj_jejuinfo());
					}
				});
			}
			
			for(int i = 0; i<buy.length; i++) {
				for(int j=0; j<la.length; j++) {
					if(j == 0) {
						la[j] = new JLabel(str[j] + startp);
					}
					if(j == 1) {
						la[j] = new JLabel(str[j] + lastp);
					}
					if(j == 2) {
						la[j] = new JLabel(str[j] + start[i]);
					}
					if(j == 3) {
						la[j] = new JLabel(str[j] + finish[i]);
					}
					la[j].setSize(120,120);
					la[j].setFont(new Font("맑은고딕", Font.BOLD, 15));
					la[j].setForeground(Color.white);
					la[j].setLocation(970,(165 + (i * 120)) + (j * 25));
					pen.add(la[j]);
				}
				pen.add(buy[i]);
				pen.add(box[i+1]);
			}
		}
	}
	class Jj_jejuinfo extends JPanel{
		private JButton [][][][] btn = new JButton[7][25][5][6]; //6크기의 1차원배열이 5개있음
		private int x=320,y=200;
		private ImageIcon [] icon = {
				new ImageIcon("images/chair2.png"),
				new ImageIcon("images/nchair.png")
		};

		public Jj_jejuinfo() {
			Container c = getContentPane();
			c.setLayout(null);
			
			JButton back = new JButton(new ImageIcon("images/back.png"));
			back.setSize(80, 73);
			back.setLocation(1300, 10);
			back.setBackground(new Color(240, 240, 240));
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton b = (JButton)e.getSource();
					c.removeAll();
					c.revalidate();
					c.repaint();
					c.add(new Jj_AirBusan());
					c.add(new Jj_koreaair());
					c.add(new Jj_jejuair());
				}
			});
			c.add(back);
			
			ImageIcon icons = new ImageIcon("images/4.jpg");
			JLabel main = new JLabel(icons);
			main.setSize(1400,1000);
			main.setLocation(0,0);
			JLabel la = new JLabel("좌석표");
			la.setFont(new Font("맑은고딕", Font.PLAIN,30));
			la.setSize(100,100);
			la.setLocation(650,10);
			
			c.add(la);
			for(int o=0; o<7; o++) {
				if(datenum == o+21) {
					for(int z = 0; z<25; z++) {
						if(btninfo == z) {
							for(int a=z; a<25; a++) {
								for(int i=0; i<5; i++) {
									if(i == 1) {
										y += 100;
										x = 320;
									}
									else if (i == 2) {
										y += 100;
										x = 320;
									}
									else if (i == 3) {
										y += 100;
										x = 320;
									}
									else if (i == 4) {
										y += 100;
										x = 320;
									}
									
									for(int j=0; j<6; j++) {
										
										btn[o][a][i][j] = new JButton(icon[0]);
										btn[o][a][i][j].setSize(90,90);
										btn[o][a][i][j].setBorderPainted(false);
										btn[o][a][i][j].setBackground(Color.white);
										btn[o][a][i][j].setLocation(x,y);
										btn[o][a][i][j].setToolTipText(Integer.toString(o)+Integer.toString(a)+Integer.toString(i)+Integer.toString(j));
										
										if(check[o][a][i][j] == true) 
											btn[o][a][i][j].setIcon(icon[1]); 

										if(j == 2) {
											x += 200;
										}
										
										c.add(btn[o][a][i][j]);
										
										btn[o][a][i][j].addMouseListener(new MouseAdapter() {
											
											public void mouseExited(MouseEvent e) {
												JButton btns = (JButton)e.getSource();
											}
											public void mousePressed(MouseEvent e) {
												JButton btns = (JButton)e.getSource();
												
												sr = btns.getToolTipText();
												System.out.println(sr);
												
												if(btns.getIcon() == icon[0]) {
													c.removeAll();
													c.revalidate();
													c.repaint();
													c.add(new buypage());
												}
											}
										});
										x += 100;
									}
								}
								c.add(main);
								return; //??
							}
							return;
						}
					}
				}
			}
		}
	
		class buypage extends JPanel{
			private String [] str = {"김해 → ", "제주", "제주항공 "," 번 항공기", 
					"출발 시간 : ", " ~ 도착 시간 : ","좌석등급 : ", 
							"예약상황 : OK","항공기 번호 : "};
			private JLabel [] la = new JLabel[7];
			private int x=80 ,y=55;
  			public buypage() {
				Container c = getContentPane();
				c.setLayout(null);
				System.out.println(btninfo);
				
				JButton back = new JButton(new ImageIcon("images/back.png")); //뒤로가기 버튼
				back.setSize(80, 73);
				back.setLocation(1300, 10);
				back.setBackground(new Color(240, 240, 240));
				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JButton b = (JButton)e.getSource();
						c.removeAll();
						c.revalidate();
						c.repaint();
						c.add(new Jj_jejuinfo());
					
					}
				});
				c.add(back);
				
				JButton background = new JButton();
				background.setSize(1200,650);
				background.setLocation(50,35);
				background.setBackground(Color.white);
				background.setEnabled(false);
				background.setBorderPainted(false);
				
				ImageIcon b = new ImageIcon("images/smalljeju.jpg");
				JLabel busan = new JLabel(b);
				busan.setSize(50,50);
				busan.setLocation(85,125);
				
				JButton bg1 = new JButton();
				bg1.setSize(1160,150);
				bg1.setLocation(70, 55);
				bg1.setBackground(new Color(255,198,198));
				bg1.setEnabled(false);
				bg1.setBorderPainted(false);

				JButton bg2 = new JButton();
				bg2.setSize(1160,250);
				bg2.setLocation(70,360);
				bg2.setBackground(new Color(147,204,141));
				bg2.setEnabled(false);
				bg2.setBorderPainted(false);
				
				for(int i=0; i<la.length; i++) { 
					la[i] = new JLabel();
					la[i].setSize(100,100);
					la[i].setLocation(x,y); //x,y 초기값 80 60
					la[i].setText(str[i]);
					la[i].setFont(new Font("맑은 고딕",Font.BOLD, 20));
					
					if(i == 1) {
						la[i].setForeground(Color.red);
						la[i].setLocation(155,55);
					}
					
					if(i == 2) { //에어부산 + 8888 번 항공기
						la[i].setSize(240,240);
						la[i].setLocation(140,28);

						for(int j=0; j<5; j++) {
							
							if(btninfo == j+20) { //btninfo = 15 16 17 18 19
								la[i].setText(str[i] + jeju_numstr[j] + str[i+1]);
							}
						}
					}
					
					if(i == 3) { //출발시간 + 도착시간
						la[i].setSize(380,380);
						la[i].setLocation(80,50);

						for(int j=0; j<5; j++) {
							if(btninfo == j+20) {
								la[i].setText(str[i+1] + jeju_go[j] + str[i+2] + jeju_end[j]);
							}
						}
					}
					if(i == 4) { //좌석등급
						la[i].setSize(160,160);
						la[i].setLocation(80,240);
										
						for(int j=0; j<5; j++) {
							if(btninfo == j+20) {
								la[i].setText(str[i+2] + jeju_seat[j]);
							}
						}
					}
					if(i == 5) { //예약상황
						la[i].setSize(160,160);
						la[i].setLocation(890,240);
						la[i].setForeground(Color.red);
						la[i].setText(str[i+2]);
						
					}
					if(i == 6) { //항공기 번호
						la[i].setSize(200,200);
						la[i].setLocation(80,180);

						for(int j=0; j<5; j++) {
							if(btninfo == j+20) {
								la[i].setText(str[i+2] + jeju_numstr[j]);
							}
						}
					}
					c.add(la[i]);
				}
				
				JButton buybtn = new JButton("예매하기");
				buybtn.setSize(90,50);
				buybtn.setLocation(600,620);
				
				buybtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int result = JOptionPane.showConfirmDialog(new buypage(), "예매 하시겠습니까?", "예매하기", JOptionPane.YES_NO_OPTION);
						int o,a,b,d;
						if(result == JOptionPane.YES_OPTION) {

							while(true) {
								
								o = Integer.parseInt(sr.substring(0,1));
								a = Integer.parseInt(sr.substring(1,3));
								b = Integer.parseInt(sr.substring(3,4));
								d = Integer.parseInt(sr.substring(4,5));
								
								check[o][a][b][d] = true;
								
								break;
							}
							c.removeAll();
							c.revalidate();
							c.repaint();
							c.add(new Jj_jejuinfo());
						}
						else if(result == JOptionPane.NO_OPTION) { }
					}
				});
				c.add(busan);
				c.add(bg1);
				c.add(bg2);
				c.add(buybtn);
				c.add(background);
			}
		}
	}
	
/////////////////////////////////////////////////////////////////////////////////
//밑에서 부터는 중국 가는거 예약하는 페이지//
////////////////////////////////////////////////////////////////////////////////
	

	
	
/////////////////////////////////////////////////////////////////////////////////
//밑에서 부터는 일본 가는거 예약하는 페이지//
////////////////////////////////////////////////////////////////////////////////	
	
	
	
	public static void main(String[] args) { new team(); }
}