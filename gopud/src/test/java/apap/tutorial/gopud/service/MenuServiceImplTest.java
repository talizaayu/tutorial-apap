package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDB;
import apap.tutorial.gopud.repository.RestoranDB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class MenuServiceImplTest {
    @InjectMocks
    MenuService menuService = new MenuServiceImpl();

    @InjectMocks
    RestoranService restoranService = new RestoranServiceImpl();

    @Mock
    MenuDB menuDB;


    @Test
    public void whenAddValidMenuItShouldCallMenuRepositorySave() {
        MenuModel newMenu = new MenuModel();
        newMenu.setNama("burger");
        newMenu.setHarga((BigInteger.valueOf(25000)));
        newMenu.setDeskripsi("keju");
        newMenu.setDurasiMasak(20);
        menuService.addMenu(newMenu);
        verify(menuDB, times(1)).save(newMenu);
    }

    @Test
    public void whenGetMenuListOrderByHargaCalledItShouldReturnMenu() {
        List<MenuModel> allMenuInDatabase = new ArrayList<>();
        for (int loopTimes = 3; loopTimes > 0; loopTimes--) {
            allMenuInDatabase.add(new MenuModel());
        }
        when (menuService.getListMenuOrderByHargaAsc(1L)).thenReturn(allMenuInDatabase);

        List<MenuModel> dataFromServiceCall = menuService.getListMenuOrderByHargaAsc(1L);
        assertEquals(3, dataFromServiceCall.size());

        verify(menuDB, times(1)).findByRestoranIdRestoranOrderByHargaAsc(1L);
    }

    @Test
    public void whenGetAllMenuByIdRestoranCalledItShouldReturnAllMenu() {
        List<MenuModel> allMenuInDatabase = new ArrayList<>();
        for (int loopTimes = 3; loopTimes > 0; loopTimes--) {
            allMenuInDatabase.add(new MenuModel());
        }
        when (menuService.findAllMenuByIdRestoran(1L)).thenReturn(allMenuInDatabase);

        List<MenuModel> dataFromServiceCall = menuService.findAllMenuByIdRestoran(1L);

        verify(menuDB, times(1)).findByRestoranIdRestoran(1L);
        assertEquals(3, dataFromServiceCall.size());
    }


}

