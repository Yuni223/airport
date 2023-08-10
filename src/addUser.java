import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.*;

@SuppressWarnings("serial")

public class addUser extends team {
	public addUser() {
		Container c = getContentPane();
		c.removeAll();
		c.revalidate();
		c.repaint();
		
		Label l1 = new Label("ID : ");
		TextField t1 = new TextField();
		Label l2 = new Label("PW : ");
		TextField t2 = new TextField();
		Label l3 = new Label("생일 : ");
		TextField t3 = new TextField("XXXXXX");
		Label l4 = new Label("주소 : ");
		TextField t4 = new TextField();
		Label l5 = new Label("특이사항 : ");
		TextField t5 = new TextField("없음.");
		
		/* 라벨 */
		add(l1);
		l1.setBounds(40,10,40,40);
		add(l2);
		l2.setBounds(40,50,40,40);
		add(l3);
		l3.setBounds(40,90,60,40);
		add(l4);
		l4.setBounds(40,130,40,40);
		add(l5);
		l5.setBounds(40,170,60,40);
		
		/* 텍스트필드 */
		add(t1);
		t1.setBounds(120,10,200,30);
		add(t2);
		t2.setBounds(120,50,200,30);
		t2.setEchoChar('*'); // 비밀번호는 별로 입력받음
		add(t3);
		t3.setBounds(120,90,200,30);
		add(t4);
		t4.setBounds(120,130,280,30);
		add(t5);
		t5.setBounds(120,180,280,120);
		
		/* 버튼 */
		JButton j1 = new JButton("가입");
		add(j1);
		j1.setBounds(125,330,80,30);
		JButton j2 = new JButton("취소");
		add(j2);
		j2.setBounds(240,330,80,30);
		JButton j3 = new JButton("중복확인");
		add(j3);
		j3.setBounds(360,10,100,30);
		
		setSize(500,420);
		setTitle("회원가입");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		j1.addActionListener(new ActionListener() { // 회원가입
					public void actionPerformed(ActionEvent e) {
						if(t1.getText().equals("") || t2.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"아이디 비밀번호를 채워주세요.");
						}
						else {
							try  {
								String s;
								BufferedReader bos = new BufferedReader(new FileReader("회원정보.txt"));
								boolean check = false;

								while ((s = bos.readLine()) != null) {
									String[] array = s.split("/");
									if (t1.getText().equals(array[0])) {
										check = true;
										break;
									}
								}
								bos.close();
								if (check) {
									JOptionPane.showMessageDialog(null, "ID Checking Please");
								}
								else {
									BufferedWriter bos1 = new BufferedWriter(new FileWriter("회원정보.txt", true));
									bos1.write(t1.getText() + "/");
									bos1.write(t2.getText() + "/");
									bos1.write(t3.getText() + "/");
									bos1.write(t4.getText() + "/");
									bos1.write(t5.getText() + "\r\n\n");
									bos1.close();
									JOptionPane.showMessageDialog(null, "회원가입을 축하합니다.");
									
									new world(); // 로그인 페이지로 이동
									setVisible(false); // 현재 창을 닫습니다.
								}
							}catch(Exception ex) { JOptionPane.showMessageDialog(null,"Error"); }
						}
					}
				});
		j2.addActionListener(new ActionListener() { // 취소
			public void actionPerformed(ActionEvent e) {
				new LoginPages();
				setVisible(false);
			}
		});
		j3.addActionListener(new ActionListener() { // 중복확인
			public void actionPerformed(ActionEvent e) {
				try  {
					String s;
					BufferedReader bos = new BufferedReader(new FileReader("회원정보.txt"));
					boolean check = false;

					while ((s = bos.readLine()) != null) {
						String[] array = s.split("/");
						if (t1.getText().equals(array[0])) {
							check = true;
							break;
						}
					}
					bos.close();
					if (check) {
						JOptionPane.showMessageDialog(null, "사용 불가능한 아이디 입니다.");
					}
					else {
						JOptionPane.showMessageDialog(null, "사용 가능한 아이디 입니다.");
					}
				} catch(Exception ex) { JOptionPane.showMessageDialog(null,"Error"); }
			}
		});
	}
	public static void main(String [] args) { new addUser(); }
}