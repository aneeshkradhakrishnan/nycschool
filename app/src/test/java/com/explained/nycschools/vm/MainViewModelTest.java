package com.explained.nycschools.vm;

import com.explained.nycschools.manager.MainVmManager;
import com.explained.nycschools.models.SchoolInfo;
import com.explained.nycschools.views.adapters.SchoolListAdapter;
import com.explained.nycschools.vm.MainViewModel.SchoolItemClickListener;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Single;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainViewModelTest {

    @Mock
    SchoolListAdapter mockAdapter;

    @Mock
    SchoolItemClickListener mockListener;

    @Mock
    MainVmManager mockManager;

    private MainViewModel subject;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        when(mockManager.getSchoolInfoList()).thenReturn(Single.just(new ArrayList<>()));
        when(mockManager.getSchoolListAdapter()).thenReturn(mockAdapter);

        subject = new MainViewModel();
        subject.setManager(mockManager);
        subject.setSchoolItemClickListener(mockListener);
    }

    @Test
    public void testGetAdapter() {
        subject.onCreate();
        assertEquals(mockAdapter, subject.getAdapter());
    }

    @Test
    public void testOnCreate() {
        subject.onCreate();
        verify(mockManager).getSchoolListAdapter();
        verify(mockAdapter).setData(anyList());
        verify(mockAdapter).setMainViewModel(subject);
    }

    @Test
    public void testItemClicked() {
        SchoolInfo info = createSchoolInfo();
        subject.itemClicked(info);
        verify(mockListener).onClick(info);
    }

    private SchoolInfo createSchoolInfo() {
        return new SchoolInfo(
                "02M260",
                "Clinton School Writers & Artists, M.S. 260",
                "M",
                "Students who are prepared for college must have an education that encourages them to take risks as they produce and perform. Our college preparatory curriculum develops writers and has built a tight-knit community. Our school develops students who can think analytically and write creatively. Our arts programming builds on our 25 years of experience in visual, performing arts and music on a middle school level. We partner with New Audience and the Whitney Museum as cultural partners. We are a International Baccalaureate (IB) candidate school that offers opportunities to take college courses at neighboring universities.",
                "1",
                "Free college courses at neighboring universities",
                "International Travel, Special Arts Programs, Music, Internships, College Mentoring English Language Learner Programs: English as a New Language",
                "English as a New Language",
                "Chelsea-Union Sq",
                "10 East 15th Street, Manhattan NY 10003 (40.736526, -73.992727)",
                "212-524-4360",
                "212-524-4365",
                "admissions@theclintonschool.net",
                "www.theclintonschool.net",
                "1, 2, 3, F, M to 14th St - 6th Ave; 4, 5, L, Q to 14th St-Union Square; 6, N, R to 23rd St",
                "BM1, BM2, BM3, BM4, BxM10, BxM6, BxM7, BxM8, BxM9, M1, M101, M102, M103, M14A, M14D, M15, M15-SBS, M2, M20, M23, M3, M5, M7, M8, QM21, X1, X10, X10B, X12, X14, X17, X2, X27, X28, X37, X38, X42, X5, X63, X64, X68, X7, X9",
                "6-11",
                "6-12",
                "376",
                "CUNY College Now, Technology, Model UN, Student Government, School Leadership Team, Music, School Musical, National Honor Society, The Clinton Post (School Newspaper), Clinton Soup (Literary Magazine), GLSEN, Glee",
                "Cross Country, Track and Field, Soccer, Flag Football, Basketball",
                "0.970000029",
                "0.899999976",
                "0.970000029",
                "1",
                "See theclintonschool.net for more information.",
                "Course Grades: English (87-100), Math (83-100), Social Studies (90-100), Science (88-100)",
                "Standardized Test Scores: English Language Arts (2.8-4.5), Math (2.8-4.5)",
                "Attendance and Punctuality",
                "Writing Exercise",
                "Group Interview (On-Site)",
                "Â—57% of offers went to this group",
                "M.S. 260 Clinton School Writers & Artists",
                "M64A",
                "Humanities & Interdisciplinary",
                "Screened",
                "80",
                "Y",
                "1515",
                "16",
                "Y",
                "138",
                "YesÂ–9",
                "Priority to continuing 8th graders",
                "Then to Manhattan students or residents",
                "Then to New York City residents",
                "19",
                "9",
                "10 East 15th Street",
                "Manhattan",
                "10003",
                "NY",
                "40.73653",
                "-73.9927",
                "5",
                "2",
                "52",
                "1089902",
                "1008420034",
                "Hudson Yards-Chelsea-Flatiron-Union Square",
                "MANHATTAN"
        );
    }
}