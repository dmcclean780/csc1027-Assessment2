package webexample;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import part02.WorkoutSession;
import part02.WorkoutType;
import web.Response;
import web.WebInterface;
import web.WebRequest;

public class WebExample 
{

	public static void main(String[] args)
	{
		WorkoutSession w1 = new WorkoutSession("Running", 30, 300.5, WorkoutType.CARDIO);
		WorkoutSession w2 = new WorkoutSession("Weightlifting", 45, 200.2, WorkoutType.STRENGTH);
		WorkoutSession w3 = new WorkoutSession("Yoga", 60, 150, WorkoutType.FLEXIBILITY);
		WorkoutSession w4 = new WorkoutSession("Tabata", 20, 250.7, WorkoutType.HIIT);
		
		ArrayList<WorkoutSession> workoutLog = new ArrayList<>();
		
		workoutLog.add(w1);
		workoutLog.add(w2);
		workoutLog.add(w3);
		workoutLog.add(w4);
		
		final String ROOT = "./";
		WebInterface winterface = new WebInterface(9990);
		ArrayList<WebRequest> wqueue = new ArrayList<WebRequest>();
		
		WebInterface.launchBrowser("http://localhost:9990");
		
		while(true)
		{
			winterface.getQueue(wqueue);
			for(int i=0;i<wqueue.size();i++)
			{
				WebRequest wr = wqueue.get(i);
				System.out.println(wr.path);
				
				if(wr.path.equals(""))
				{
					String page = "<HTML><BODY>";
					page += "<A href='/workoutLog'>Workout Log</A>";
					page += "<BR>";
					page += "<A href='/addWorkoutSessionForm'>Add Workout Session</A>";
					page += "<BR>";
					page += "<A href='/workoutLogWithLinks'>Workout Log With Links</A>";
					page += "<BR>";
					page += "</BODY></HTML>";
					
					wr.r = new Response(WebRequest.HTTP_OK,WebRequest.MIME_HTML,page);
				}
				else
				if(wr.path.equalsIgnoreCase("workoutLog"))
				{
					String page = "<HTML><BODY>";

					page += "<H1>Workout Log</H1>";
					for(int workoutSessionIndex=0;workoutSessionIndex<workoutLog.size();workoutSessionIndex++)
					{
						WorkoutSession workoutSession = workoutLog.get(workoutSessionIndex); 
						page += workoutSession.toString();
						page += "<BR>";
					}
					
					page += "</BODY></HTML>";
					
					wr.r = new Response(WebRequest.HTTP_OK,WebRequest.MIME_HTML,page);
					
				}
				else
				if(wr.path.equalsIgnoreCase("addWorkoutSessionForm"))
				{
					String page = "<HTML><BODY>";

					page += "<H1>Add Workout Session</H1>";
					page += "<FORM  action='/addWorkoutSession'>";
					page += "<LABEL for 'myName'>Name:</LABEL>";
					page += "<INPUT  type='text' id='myName' name='myNameInForm'>";
					page += "<LABEL for 'myDuration'>Duration:</LABEL>";
					page += "<INPUT  type='text' id='myDuration' name='myDurationInForm'>";
					page += "<INPUT  type='submit' value='Submit'>";
					page += "</FORM>";

					page += "</BODY></HTML>";

					wr.r = new Response(WebRequest.HTTP_OK,WebRequest.MIME_HTML,page);
				}
				else
				if(wr.path.equalsIgnoreCase("addWorkoutSession"))
				{
					String uri = "/workoutLog";
					
					String myName = wr.parms.get("myNameInForm");
					String myDuration = wr.parms.get("myDurationInForm");
					
					System.out.println("myName="+myName);
					System.out.println("myDuration="+myDuration);
					
					wr.r = new Response( WebRequest.HTTP_REDIRECT, WebRequest.MIME_HTML,
							   "<html><body>Redirected: <a href=\"" + uri + "\">" +
							   uri + "</a></body></html>");
					wr.r.addHeader( "Location", uri );
				}
				else
				if(wr.path.equalsIgnoreCase("workoutLogWithLinks"))
				{
					String page = "<HTML><BODY>";

					page += "<H1>Workout Log</H1>";
					for(int workoutSessionIndex=0;workoutSessionIndex<workoutLog.size();workoutSessionIndex++)
					{
						WorkoutSession workoutSession = workoutLog.get(workoutSessionIndex); 
						page += "<A href='/workoutSession/"+workoutSession.getId()+"'>";
						page += workoutSession.toString();
						page += "</A>";
						page += "<BR>";
					}
					
					page += "</BODY></HTML>";
					
					wr.r = new Response(WebRequest.HTTP_OK,WebRequest.MIME_HTML,page);
					
				}
				else
				if(wr.path.toLowerCase().startsWith("workoutSession".toLowerCase()))
				{
					String page = "<HTML><BODY>";
					page += "<H1>Workout Session</H1>";
					String workoutSessionIDAsString = wr.path.substring("workoutSession/".length());
					boolean found = false;
					try
					{
						int workoutSessionID = Integer.parseInt(workoutSessionIDAsString);
						for(int workoutSessionIndex=0;workoutSessionIndex<workoutLog.size();workoutSessionIndex++)
						{
							WorkoutSession workoutSession = workoutLog.get(workoutSessionIndex); 
							if(workoutSession.getId()==workoutSessionID)
							{
								page += workoutSession.toString();
								found = true;
								break;
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
					if(!found)
					{
						page += "Workout Session ID:"+workoutSessionIDAsString+" not found";
					}
					
					page += "</BODY></HTML>";
					
					wr.r = new Response(WebRequest.HTTP_OK,WebRequest.MIME_HTML,page);
					
				}
				else
				{
					//This code will look on disk for a file, change the ROOT variable to load files from a different directory
					File f = new File(ROOT+wr.path);
					if(f.exists())
					{
						try {
							long maxlen = f.length();
							FileInputStream fis = new FileInputStream( f );
							
							//This range and offset code enables a webserver to request part of a file, this supports applications like streaming video
							long startFrom = 0;
							long endat = -1;
							long rangebytes = -1;
							String resulttype = WebRequest.HTTP_OK;
							String range = wr.parms.get( "Range" );
							String rangeend = null;
							if ( range != null )
							{
								System.out.println(range);
								if ( range.startsWith( "bytes=" ))
								{
									resulttype = WebRequest.HTTP_PARTIAL;
									range = range.substring( "bytes=".length());
									int minus = range.indexOf( '-' );
									if ( minus > 0 )
									{
										rangeend = range.substring( minus+1 );
										range = range.substring( 0, minus );
									}
									try	
									{
										startFrom = Long.parseLong( range );
										endat = Long.parseLong(rangeend);
									}
									catch ( NumberFormatException nfe ) 
									{
										rangebytes = 512*1024;
										if(rangebytes>(maxlen-startFrom))
										{
											resulttype = WebRequest.HTTP_OK;
											rangebytes = (maxlen-startFrom);
										}
										else
										{
											resulttype = WebRequest.HTTP_PARTIAL;						
										}
									}
									
								}
								if(endat!=-1)
								{
									rangebytes = endat-startFrom;
								}
								else
								{
										rangebytes = (maxlen-startFrom);
								}
							}
							else
							{
								long chunk = 100*1024*1024;
								rangebytes = maxlen-startFrom;
								if(rangebytes>chunk)
								{
									rangebytes = chunk;
									resulttype = WebRequest.HTTP_PARTIAL;						
								}
							}
				
							try
							{
								fis.skip( startFrom );
							}
							catch(Exception e)
							{
								System.out.println(e.toString());
							}
							
							String mime = WebRequest.getMimeType(wr.path);
								
							wr.r = new Response( resulttype, mime, rangebytes, fis );
							wr.r.addHeader( "Content-length", "" + (rangebytes));
							wr.r.addHeader( "Content-range", "bytes " + startFrom + "-" +
											(startFrom+rangebytes-1) + "/" + maxlen);
						} catch(Exception e) {
							wr.r = new Response(WebRequest.HTTP_NOTFOUND,WebRequest.MIME_HTML,"");	
						}
					}
					else
					{
						wr.r = new Response(WebRequest.HTTP_NOTFOUND,WebRequest.MIME_HTML,"");											
					}
				}
				
				Thread t = new Thread( wr );
				t.setDaemon( true );
				t.start();
			}

			try
			{
				wqueue.clear();
				Thread.sleep(10);
			}
			catch(Exception e)
			{
				
			}
		}
	}
}
