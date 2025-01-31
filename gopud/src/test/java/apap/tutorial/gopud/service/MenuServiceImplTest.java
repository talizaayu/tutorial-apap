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

    @Test
    public void whenGetMenuByIdCalledByExistingDataItShouldReturnCorrectData() {
        MenuModel returnedData = new MenuModel();
        returnedData.setNama("burger");
        returnedData.setHarga(BigInteger.valueOf(25000));
        returnedData.setDeskripsi("keju");
        returnedData.setDurasiMasak(20);

        when(menuService.getMenuById(1L)).thenReturn(Optional.of(returnedData));
        Optional<MenuModel> dataFromServiceCall = menuService.getMenuById(1L);

        verify(menuDB, times(1)).findById(1L);
        assertTrue(dataFromServiceCall.isPresent());
        MenuModel dataFromOptional = dataFromServiceCall.get();

        assertEquals("burger", dataFromOptional.getNama());
        assertEquals(BigInteger.valueOf(25000), dataFromOptional.getHarga());
        assertEquals("keju", dataFromOptional.getDeskripsi());
        assertEquals(Integer.valueOf(20), dataFromOptional.getDurasiMasak());
    }

    @Test
    public void whenChangeMenuCalledItShouldChangeMenuData() {
        MenuModel updatedData = new MenuModel();
        updatedData.setNama("burger");
        updatedData.setHarga(BigInteger.valueOf(25000));
        updatedData.setDeskripsi("keju");
        updatedData.setDurasiMasak(Integer.valueOf(20));
        updatedData.setId((long)1);
        menuService.addMenu(updatedData);

        when(menuDB.findById(1L)).thenReturn(Optional.of(updatedData));
        when(menuService.changeMenu(updatedData)).thenReturn(updatedData);

        MenuModel dataFromServiceCall = menuService.changeMenu(updatedData);
        assertEquals("burger", dataFromServiceCall.getNama());
        assertEquals(BigInteger.valueOf(25000), dataFromServiceCall.getHarga());
        assertEquals("keju", dataFromServiceCall.getDeskripsi());
        assertEquals(Integer.valueOf(20), dataFromServiceCall.getDurasiMasak());
        assertEquals(Long.valueOf(1), dataFromServiceCall.getId());
    }

    @Test
    public void whenChangeMenuCalledButNotFound() {
        MenuModel updatedData = new MenuModel();
        updatedData.setId((long)1);

        when(menuDB.findById(1L)).thenReturn(Optional.of(updatedData));
        when(menuService.changeMenu(updatedData)).thenThrow(new NullPointerException());

        assertNull(menuService.changeMenu(updatedData));
    }

    @Test
    public void whenDeleteMenuCalledItShouldDeleteMenuData(){
        MenuModel menuModel = new MenuModel();
        menuModel.setId((long) 1);
        lenient().when(menuDB.findById(1L)).thenReturn(Optional.of(menuModel));
        menuService.deleteMenu(menuModel);
        verify(menuDB, times(1)).deleteById(1L);
    }

}

