package tlaloc.mng687.tlalocsample;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import tlaloc.mng687.tlalocsample.fragment.QuizListFragment;
import tlaloc.mng687.tlalocsample.fragment.TipListFragment;
import tlaloc.mng687.tlalocsample.fragment.TutorialListFragment;
import tlaloc.mng687.tlalocsample.model.Quiz;
import tlaloc.mng687.tlalocsample.model.Tip;
import tlaloc.mng687.tlalocsample.model.Tutorial;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {
    private static final int SECTION_QUIZ = 0;
    private static final int SECTION_TUTORIALS = 1;
    private static final int SECTION_TIPS = 2;

    private String[] mUrls;
    private RequestQueue mRequestQueue;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRequestQueue = Volley.newRequestQueue(this);
        mUrls = new String[] {
                getString(R.string.server_url) + "/quizzes.json",
                getString(R.string.server_url) + "/tutorials.json",
                getString(R.string.server_url) + "/tips.json"
        };

        setContentView(R.layout.activity_main);

        /*
          Fragment managing the behaviors, interactions and presentation of the navigation drawer.
        */
        NavigationDrawerFragment mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        GsonRequest request  = null;

        switch (position) {
            case SECTION_QUIZ:
                request = new GsonRequest<>(
                        mUrls[SECTION_QUIZ],
                        Quiz[].class,
                        null,
                        new Response.Listener<Quiz[]>() {
                            @Override
                            public void onResponse(Quiz[] quizzes) {
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container, QuizListFragment.newInstance(quizzes))
                                        .commit();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                            }
                        }
                );
                break;
            case SECTION_TUTORIALS:
                request = new GsonRequest<>(
                        mUrls[SECTION_TUTORIALS],
                        Tutorial[].class,
                        null,
                        new Response.Listener<Tutorial[]>() {
                            @Override
                            public void onResponse(Tutorial[] tutorials) {
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container, TutorialListFragment.newInstance(tutorials))
                                        .commit();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                            }
                        }
                );
                break;
            case SECTION_TIPS:
                request = new GsonRequest<>(
                        mUrls[SECTION_TIPS],
                        Tip[].class,
                        null,
                        new Response.Listener<Tip[]>() {
                            @Override
                            public void onResponse(Tip[] tips) {
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.container, TipListFragment.newInstance(tips))
                                        .commit();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                            }
                        }
                );
                break;
            default:
                break;
        }

        if(request != null) {
            mRequestQueue.add(request);
            mRequestQueue.start();
        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
