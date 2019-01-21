package control;

import java.util.Random;
import java.util.Scanner;

import fraction.Fractions;
import question.Question;

public class Control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���ι���"+args[1]+"���⡣");
		if(args[0].equals("-n")){
			Scanner scanner=new Scanner(System.in);
			Integer num=new Integer(args[1]);
			int correct=0;
			String answer[]=new String[num];//�û�����Ĵ�
            Random random = new Random();
            boolean judge[] = new boolean[num];//�����û�����Դ�
            Question[] questions = new Question[num];
            for(int i=0;i<num;i++){
            	questions[i] = new Question(random.nextInt(10)+1);
            	System.out.print((i+1)+":"+questions[i].getExpression());
            	answer[i] = scanner.nextLine();
            	Fractions result = questions[i].getResult();
            	int result_int = result.changeToInteger();
            	if(!answer[i].equals("")){
            	if(result_int!=Integer.MAX_VALUE){
            		if(Integer.parseInt(answer[i])==result_int){
            			judge[i]=true;
            			System.out.println("��ȷ��");
            			correct++;
            		}else{
            			judge[i]=false;
            			System.out.println("����ȷ����ȷ�𰸣�"+result_int);
            		}
            	}else{
            		String splits[] = answer[i].split("/");
            		if(splits.length==2&&Integer.parseInt(splits[0])==result.getNumerator()&&Integer.parseInt(splits[1])==result.getDenominator()){
            			judge[i]=true;
            			System.out.println("��ȷ��");
            			correct++;
            		}else{
            			judge[i]=false;
            			System.out.println("����ȷ����ȷ�𰸣�"+result.printFraction());
            		}
            	}
            	}else{
            		judge[i]=false;
        			System.out.println("δ�ش���ȷ�𰸣�"+result.printFraction());
            	}
            }
            double score = (double)correct/(double)num*100.00;
            System.out.println("���ε÷֣�"+score);
            scanner.close();
		}else{
			System.out.println("��������");
		}

	}

}
