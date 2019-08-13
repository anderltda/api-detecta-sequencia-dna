package br.com.api.sequencia.dna;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import br.com.api.sequencia.dna.service.DetectaSequenciaGeneticaService;


/**
 * @author Anderson Nascimento
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class StartApiApplicationTests {

    @InjectMocks
    private DetectaSequenciaGeneticaService detectaSequenciaGeneticaService;


    @Before
    public void setup() {

    }

    @Test
    public void tem_que_ser_um_simio() {

        String[] dna = {"CTGAGA", "CTATGC", "TATTGT", "AGAGGG", "TCCCCA", "TCACTG"};

        Assert.assertTrue(detectaSequenciaGeneticaService.isSimian(dna));

    }

    @Test
    public void tem_que_ser_um_humano() {

        String[] dna = {"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA", "TCACTG"};

        Assert.assertFalse(detectaSequenciaGeneticaService.isSimian(dna));

    }
}
