package acm.ti;

public class demo3 
{
	public static void main(String args[])
	{
		int count=0;
		for(double a=1;a<=9;a++)
		{
			for(double b=1;b<=9;b++)
			{
				if(a!=b){
					for(double c=1;c<=9;c++)
					{
						if(a!=c&&b!=c){
							for(double d=1;d<=9;d++)
							{
								if(a!=d&&b!=d&&c!=d){
									for(double e=1;e<=9;e++)
									{
										if(a!=e&&b!=e&&c!=e&&d!=e){
											for(double f=1;f<=9;f++)
											{
												if(a!=f&&b!=f&&c!=f&&d!=f&&e!=f){
													for(double g=1;g<=9;g++)
													{
														if(a!=g&&b!=g&&c!=g&&d!=g&&e!=g&&f!=g){
															for(double h=1;h<=9;h++)
															{
																if(a!=h&&b!=h&&c!=h&&d!=h&&e!=h&&f!=h&&g!=h){
																	for(double i=1;i<=9;i++)
																	{
																		if(a!=i&&b!=i&&c!=i&&d!=i&&e!=i && f!=i && g!=i&&h!=i){
																			
																			double end=a + b/c + (d*100 + e*10 + f)/(g*100 + h*10 + i);
																			if( end== 10){
                                                                                count ++;
                                                                            }

																		}
																	}	
																}
															}	
														}
													}	
												}
											}	
										}
									}	
								}
							}	
						}
					}	
				}
			}	
		}
		
		System.out.println(count);
	}

}
